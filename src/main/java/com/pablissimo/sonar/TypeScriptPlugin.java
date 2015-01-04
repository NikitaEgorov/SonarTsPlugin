package com.pablissimo.sonar;

import java.util.Arrays;
import java.util.List;

import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.PropertyType;
import org.sonar.api.SonarPlugin;

@Properties({
	@Property(
		key = "sonar.ts.tslintpath",
		defaultValue = "",
		name = "Path to TSLint",
		description = "Path to installed Node TSLint",
		project = false, 
		global = true
	),
	@Property(
		key = "sonar.ts.excludetypedefinitionfiles",
		type = PropertyType.BOOLEAN,
		defaultValue = "true",
		name = "Exclude .d.ts files",
		description = "Exclude .d.ts files from analysis",
		project = true,
		global = false
	),
	@Property(
		key = TypeScriptPlugin.SETTING_LCOV_REPORT_PATH,
		type = PropertyType.STRING,
		name = "LCOV report path",
		description = "LCOV report path",
		project = true,
		global = false
	)
	})
public class TypeScriptPlugin extends SonarPlugin {
	public static final String SETTING_TS_LINT_PATH = "sonar.ts.tslintpath";
	public static final String SETTING_LCOV_REPORT_PATH = "sonar.ts.lcovreportpath";
	
	@SuppressWarnings({ "rawtypes" })
	public List getExtensions() {
		return Arrays.asList
				(
					TypeScriptRuleProfile.class,
					TypeScriptLanguage.class, 
				    TsLintSensor.class,
				    TsCoverageSensor.class,
					TsRulesDefinition.class
				);
	}
}