package com.pablissimo.sonar;

import java.util.List;

public interface TsLintExecutor {
    String execute(String pathToTsLint, String configFile, String rulesDir, List<String> files, Integer timeoutMs);
}
