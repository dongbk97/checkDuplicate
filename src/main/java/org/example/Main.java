package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Condition> listCondition2 = Condition.listCondition().stream().filter(distinctByKeyResult()).collect(Collectors.toList());
        resultList(listCondition2).forEach(System.out::println);

    }

    private static List<Condition> resultList(List<Condition> conditions) {

        Set<String> uniqueKeys = new HashSet<>();
        List<Condition> filteredConditions = new ArrayList<>();

        for (Condition condition : conditions) {
            String key = condition.getBankCode() + "-" + condition.getToAccount();
            if (!uniqueKeys.contains(key)) {
                uniqueKeys.add(key);
                filteredConditions.add(condition);
            } else {
                for (int i = 0; i < filteredConditions.size(); i++) {
                    Condition existingCondition = filteredConditions.get(i);
                    if (existingCondition.getBankCode().equals(condition.getBankCode()) && existingCondition.getToAccount().equals(condition.getToAccount())) {
                        if (getSourcePriority(condition.getSourceResult()) > getSourcePriority(existingCondition.getSourceResult())) {
                            filteredConditions.set(i, condition);
                        }
                        break;
                    }
                }
            }
        }
        return filteredConditions;
    }


    public static Predicate<Condition> distinctByKeyResult() {
        Map<String, Condition> map = new HashMap<>();
        return dto -> {
            String key = dto.getToAccount() + "-" + dto.getBankCode();
            if (map.containsKey(key)) {
                Condition existingDto = map.get(key);
                String existingSourceResult = existingDto.getSourceResult();
                String currentSourceResult = dto.getSourceResult();
                boolean dk1 = existingSourceResult.equalsIgnoreCase(CommonConstant.LSGD);
                boolean dk2 = (existingSourceResult.equalsIgnoreCase(CommonConstant.VTM) && !currentSourceResult.equalsIgnoreCase(CommonConstant.LSGD));
                boolean dk3 = (existingSourceResult.equalsIgnoreCase(CommonConstant.CSDL) && !currentSourceResult.equalsIgnoreCase(CommonConstant.LSGD) && !currentSourceResult.equalsIgnoreCase(CommonConstant.VTM));

                // Kiểm tra độ ưu tiên của SourceResult
                if (dk1) {
                    return false;
                } else if (dk2) {
                    return false;
                } else if (dk3) {
                    return false;
                }
                // Thay thế bản ghi trước đó với bản ghi hiện tại
                map.put(key, dto);
            } else {
                map.put(key, dto);
            }
            return true;
        };
    }

    private static int getSourcePriority(String sourceResult) {
        if (sourceResult.equalsIgnoreCase(CommonConstant.LSGD)) {
            return 3;
        } else if (sourceResult.equalsIgnoreCase(CommonConstant.VTM)) {
            return 2;
        } else if (sourceResult.equalsIgnoreCase(CommonConstant.CSDL)) {
            return 1;
        } else {
            return 0;
        }
    }
}
