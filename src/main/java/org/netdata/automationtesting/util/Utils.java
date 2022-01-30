package org.netdata.automationtesting.util;

import io.vavr.Function2;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UtilityClass
public class Utils {

    public Function2<List<String>, List<String>, Map<String, List<String>>> getMapFromLists = (columnNames, rowValues) -> {
        Map<String, List<String>> table = new HashMap<>();
        for (int i = 0; i < columnNames.size(); i++) {
            List<String> valuesPerRow = new ArrayList<>();
            for (int j = i; j < rowValues.size(); j+=columnNames.size()) {
                valuesPerRow.add(rowValues.get(j));
            }
            table.put(columnNames.get(i), valuesPerRow);
        }
        return table;
    };

}
