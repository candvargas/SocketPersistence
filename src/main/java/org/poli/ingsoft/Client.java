package org.poli.ingsoft;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Works like client socket
 */
public class Client {
    private final String HOST = "127.0.0.1";
    private final int PORT = 5000;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private Socket socket;

    /**
     * Sending messages using sockets
     * @param message
     * @return
     */
    public String sendingMessage(String message) {
        try {
            out = new DataOutputStream(this.socket.getOutputStream());
            out.writeUTF(message);
            return message;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Receiving messages using sockets
     * @param in
     * @return
     */
    public String receivingMessage(DataInputStream in) {
        String receiveMessage = null;
        try {
            receiveMessage = in.readUTF();
            System.out.println(receiveMessage);
            return receiveMessage;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Start session with server socket
     */
    public void startSession() {
        try {
            socket = new Socket(HOST, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            int amountEmployees;
            do {
                receivingMessage(in);
                Scanner sc = new Scanner(System.in);
                int option = Integer.parseInt(sendingMessage(sc.nextLine()));
                switch (option) {
                    case 1://REGISTRAR EMPLEADO
                        receivingMessage(in);//Primer nombre
                        sendingMessage(sc.next());
                        receivingMessage(in);//Segundo nombre
                        sendingMessage(sc.next());
                        receivingMessage(in);//Email
                        sendingMessage(sc.next());
                        receivingMessage(in);//Fecha de nacimiento
                        sendingMessage(sc.next());
                        receivingMessage(in);//Sueldo
                        sendingMessage(sc.next());
                        receivingMessage(in);//Comision
                        sendingMessage(sc.next());
                        receivingMessage(in);//Cargo Id
                        sendingMessage(sc.next());
                        receivingMessage(in);//Gerente Id
                        sendingMessage(sc.next());
                        receivingMessage(in);//Departamento Id
                        sendingMessage(sc.next());
                        receivingMessage(in);//Query
                        break;
                    case 2://ACTUALIZAR EMPLEADO
                        receivingMessage(in);
                        sendingMessage(sc.next());//Id empleado
                        receivingMessage(in);//Primer nombre
                        sendingMessage(sc.next());
                        receivingMessage(in);//Segundo nombre
                        sendingMessage(sc.next());
                        receivingMessage(in);//Email
                        sendingMessage(sc.next());
                        receivingMessage(in);//Fecha de nacimiento
                        sendingMessage(sc.next());
                        receivingMessage(in);//Sueldo
                        sendingMessage(sc.next());
                        receivingMessage(in);//Comision
                        sendingMessage(sc.next());
                        receivingMessage(in);//Cargo Id
                        sendingMessage(sc.next());
                        receivingMessage(in);//Gerente Id
                        sendingMessage(sc.next());
                        receivingMessage(in);//Departamento Id
                        sendingMessage(sc.next());
                        receivingMessage(in);//Query
                        break;
                    case 3://ELIMINAR EMPLEADO
                        receivingMessage(in);//IdEmpleado
                        sendingMessage(sc.next());
                        receivingMessage(in);//Query
                        break;
                    case 4://BUSCAR EMPLEADO
                        receivingMessage(in);//IdEmpleado
                        sendingMessage(sc.next());
                        receivingMessage(in);//Query
                        break;
                    case 5://LISTAR EMPLEADOS
                        receivingMessage(in);
                        amountEmployees = Integer.parseInt(receivingMessage(in));
                        for (int i = 0; i < amountEmployees; i++) {
                            receivingMessage(in);
                        }
                        break;
                    case 0://|SALIENDO...|
                        receivingMessage(in);
                        break;
                    default://"Opción no válida!"
                        receivingMessage(in);

                }

                if (option == 0) {
                    this.socket.close();
                } else {
                    receivingMessage(in);
                    option = Integer.parseInt(sendingMessage(sc.next()));
                    if (option != 1) {
                        sendingMessage("|SALIENDO...|");
                        this.socket.close();
                    }
                }
            } while (!this.socket.isClosed());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.startSession();
    }
}
