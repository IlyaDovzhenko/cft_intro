package main.java;

import java.util.ArrayList;
import java.util.List;

class Parameters {
    /* -a(возрастание - Ascending) -d(убывание - descending) -
    режим сортировки(необязательный), по умолчанию сортируем по возрастанию; */
    private String direction = "asc";
    // -s(string) -i(integer) - тип данных(обязательный);
    private String inputType = null;
    // имя выходного файла(обязательное);
    private String outputFile;
    // имена входных файлов, не менее одного.
    private List<String> inputFiles = new ArrayList<>();

    Parameters(String[] parameters) {
        List<String> inputPaths = new ArrayList<>();

        for (String parameter : parameters) {
            if (parameter.contains("-")) {
                switch (parameter) {
                    case ("-d"): this.direction = "desc";
                        break;
                    case ("-s"): this.inputType = "string";
                        break;
                    case ("-i"): this.inputType = "integer";
                        break;
                }
            }
            if (parameter.contains(".txt")) {
                inputPaths.add(parameter);
            }
        }
        for (int i = 0; i < inputPaths.size(); i++) {
            if (i == 0) {
                this.outputFile = inputPaths.get(i);
                inputPaths.remove(i);
            }
        }
        this.inputFiles.addAll(inputPaths);

    }

    String getDirection() {
        return direction;
    }

    String getInputType() {
        return inputType;
    }

    String getOutputFile() {
        return outputFile;
    }

    List<String> getInputFiles() {
        return inputFiles;
    }
}
