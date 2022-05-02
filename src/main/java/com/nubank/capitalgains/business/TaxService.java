package com.nubank.capitalgains.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nubank.capitalgains.business.rules.TaxValidator;
import com.nubank.capitalgains.exceptions.ReadLineException;
import com.nubank.capitalgains.model.Simulation;
import com.nubank.capitalgains.model.State;
import com.nubank.capitalgains.utils.FileReaderUtil;
import java.io.IOException;
import java.util.Objects;
import org.json.JSONArray;

public class TaxService {
    private final FileReaderUtil fileReaderUtil;
    private final TaxValidator taxValidator;
    private final ObjectMapper mapper;

    public TaxService(FileReaderUtil fileReaderUtil) {
        this.fileReaderUtil = fileReaderUtil;
        State state = new State();
        taxValidator = new TaxValidator(state);
        mapper = new ObjectMapper();
    }

    public String process() {
        StringBuilder result = new StringBuilder();
        try {
            String line, registry;
            while (!Objects.equals(line = fileReaderUtil.next(), "")) {
                JSONArray jsonArray = new JSONArray(line);
                taxValidator.resetState();
                for (int i = 0; i < jsonArray.length(); i++) {
                    registry = jsonArray.getJSONObject(i).toString().replace("-","");
                    Simulation simulation = mapper.readValue(registry, Simulation.class);
                    taxValidator.validate(simulation);
                }
                result.append(taxValidator.getTaxResult()).append("\n");
            }
        } catch (IOException e) {
            throw new ReadLineException("FileReaderUtil failed while reading line!",e);
        }
        return result.toString();
    }
}
