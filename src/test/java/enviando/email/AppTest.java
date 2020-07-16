package enviando.email;

public class AppTest {

	@org.junit.Test
	public void testeEmail() {

		try {

			ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("aqui vai o email", "nome de que está enviando",
					"assunto do email", "corpo do email");
			
			enviaEmail.enviarEmail();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
