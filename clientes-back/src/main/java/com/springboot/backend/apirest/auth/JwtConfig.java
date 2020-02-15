package com.springboot.backend.apirest.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpAIBAAKCAQEAwegxAaxD+VxVOVJ3naGu9CVehQdfLYLuRS0RhskmWDi1bNP7\r\n" + 
			"n4LogIkpdaEnZvJLqv4ZJO8Lr44AFwvFkTzh6hBgDBOrBh4VPnigdnWI6NkVVwGM\r\n" + 
			"9tTEtMTsAJu8rcxUMhSm5t/fvfasd/Qpi06sygRRfRXap/qI5hiEoc8nPuBOAbRj\r\n" + 
			"5brHM2AeqqX9pFl5+u7F/9ZSwMWNMnmV4jasDnCe3q3Dfuf/NH1tnJRQPB1Mv/yo\r\n" + 
			"m184n2BRvjVaA2XiVzB0lNMOIyR6F8HBfdhuxCNlp9GqqPxbyIYy5lyKGrZos2O3\r\n" + 
			"Yv7le9OqlQzkjsmWSyzy9MOZfbzbhBVxIDaQkQIDAQABAoIBACx6j2s70afMdzwb\r\n" + 
			"35ZH9TLJs6G+LCXrZ650hRWu5F3OPEeHZKuVQrHhRKJX4grqP1Ms0CW5s6uEXh7r\r\n" + 
			"M1l6ZrPjJ7T9efiARA09bElf8pS+3vdDQsuHyMtSdHQ7RQ901Edcl2BUMCWKBMvL\r\n" + 
			"NRBgbqA0V2Di93IatPZa32mic/Um5eFWUtA42JFFzl+ZVtz2qmNJq9fGDUwwIoDy\r\n" + 
			"MSEIxgakCH0qHkdzac/iyuiJ4sqsmAIf6W8Wjf/LtheNj35pHeoVaamVnN22gk6A\r\n" + 
			"7Dy4jsQg3yuu2mEpzEHoFd9H7ok8PuzQsaEPajmtX5tei7ZOe1VLXlDfh8ZrMjh8\r\n" + 
			"YGmelsUCgYEA9nuVj0u/sFCjpcNQs6KTlm4oXTRSxsDAsXRItBmE7nbL5ZUiyhBA\r\n" + 
			"NqFbmPjs7XcKUY4dwyH+/Bjb0HLuWs6C+LIRQ4hc/JQQuAL7zj1ATJLpLp9D960k\r\n" + 
			"VNl9dYDzbyGxoTQmq3ueNt3W2df5qaITJJXed6W+hy0AzKWhYb63ZpcCgYEAyWTo\r\n" + 
			"9uxOR9e2Qzzb1DX1YJib/MVrUCfGWXN9MESIRgGZH+s96N7DjbvWs4djjYmiuuoT\r\n" + 
			"scYB7V4lczB6sl8OrBS+ISS5HzX0/GxIS89r85a16PZMPOLO0vuP0bkG/Hh4DBbw\r\n" + 
			"6xwZbVNa+2au8Z3QJbpNG+PS12Urje3jgDvCjxcCgYAvZFnAYKctxoOApspIj9Ti\r\n" + 
			"0rFuIlZcIsmqFRq5jkKR+0N/FCrJQVCncGUFR69+hSn1vmaYk1vMqxbwwHh1+0kR\r\n" + 
			"emN5YanHYszIJMK3x+0qDAFL1pGh+KeIrPzDcBTeZFMcFMPuqukj0Ymy/yTg6enW\r\n" + 
			"Wf6ZcMPuh8ekkaAzBBGNZwKBgQCFAHh+AedcuM/srbd7+TqY1ZBGqdZKNEpg7s1h\r\n" + 
			"YBEjMpD+rGvRa7R32PJc0+/iHGB00nu5Lsw9B6zx2rVdMTvOV1CNMOR1ATxOq/A+\r\n" + 
			"6LghQYnXVTlaCGuQmIQNfAVqHOEjEs9+ZatBMQhn+RNWC+PX1qZv4dBvYagW7mEN\r\n" + 
			"YeoGdwKBgQDYlTrZ1HALJGI9R8v56cUfWJON5rppo6tSCl5YXpVlOGoazbbk92s6\r\n" + 
			"6LYOzNBPGMERadVPgKCzkXOgSAQwB8PAHRIF3qUVeEiQMIIhIWC1z7UML6uXlTJ2\r\n" + 
			"61jyqJwYU7sUPZQm2Vn+yxsYZtlbu9Pj9zohtzCkdsNGc8oobIONlA==\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwegxAaxD+VxVOVJ3naGu\r\n" + 
			"9CVehQdfLYLuRS0RhskmWDi1bNP7n4LogIkpdaEnZvJLqv4ZJO8Lr44AFwvFkTzh\r\n" + 
			"6hBgDBOrBh4VPnigdnWI6NkVVwGM9tTEtMTsAJu8rcxUMhSm5t/fvfasd/Qpi06s\r\n" + 
			"ygRRfRXap/qI5hiEoc8nPuBOAbRj5brHM2AeqqX9pFl5+u7F/9ZSwMWNMnmV4jas\r\n" + 
			"DnCe3q3Dfuf/NH1tnJRQPB1Mv/yom184n2BRvjVaA2XiVzB0lNMOIyR6F8HBfdhu\r\n" + 
			"xCNlp9GqqPxbyIYy5lyKGrZos2O3Yv7le9OqlQzkjsmWSyzy9MOZfbzbhBVxIDaQ\r\n" + 
			"kQIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
}
