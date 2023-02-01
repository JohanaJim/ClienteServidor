package view;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws Exception {
		String textoCliente;
		String textoEnvio;

		// cria socket de comunica��o com os clientes na porta 6789
		@SuppressWarnings("resource")
		ServerSocket bemVindoSocket = new ServerSocket (6789);

		// espera mensagem de algum cliente e trata

            // cria o strem do teclado

			BufferedReader cadeiaServidor = new BufferedReader(new InputStreamReader(System.in));

			//espera a conex�o de algum cliente
			Socket conexaoSocket = bemVindoSocket.accept();

			//cria strem de entra e saida com cliente que chegou
			BufferedReader cadeiaCliente = new BufferedReader(new InputStreamReader(conexaoSocket.getInputStream()));
            DataOutputStream ServidorParaCliente = new DataOutputStream(conexaoSocket.getOutputStream());

			while(true) {
                // l� uma linha do cliente
                textoCliente = cadeiaCliente.readLine();
                System.out.println("Do cliente: " + textoCliente);

                // envia pro cliente
                System.out.print("Server: Este es una modificacòn ");
                textoEnvio = cadeiaServidor.readLine();
                ServidorParaCliente.writeBytes(textoEnvio + "\n");
		    }



	}

}
