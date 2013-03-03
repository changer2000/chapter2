package my.study.ch5.properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	
	private static String[] encryptPropNames = new String[] {
		"driverClassName", "url",
		"userName", "password"
		};
	
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (isEncryptProp(propertyName)) {
			return DESUtils.getDecryptString(propertyValue);
		} else
			return propertyValue;
	}
	
	private boolean isEncryptProp(String propertyName) {
		for (String encryptPropName : encryptPropNames) {
			if (encryptPropName.equals(propertyName))
				return true;
		}
		return false;
	}
	
}
