package org.poli.ingsoft;

import org.poli.ingsoft.DAOs.DaoFactory;
import org.poli.ingsoft.DAOs.IDao;
import org.poli.ingsoft.models.Empleado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * It works like socket server
 */
public class Server {
    public static final int PUERTO = 5000;
    public DataOutputStream out;
    public DataInputStream in;
    public ServerSocket serverSocket;
    public Socket cliente;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    /**
     * Method to start server
     */
    public void startServer() {
        System.out.println("Servidor iniciado y contestando OK");
        try {
            cliente = this.serverSocket.accept();
            Empleado empleado = new Empleado();

            //Create instance to connect to the DB
            IDao dao = DaoFactory.getDao(DaoFactory.DaoType.EMPLEADO);

            List<Empleado> empleados = new ArrayList<>();

            int opcion;
            Long IdEmpleado;
            String message;

            do {
                StringBuilder strBuilder = showMenu();
                in = new DataInputStream(cliente.getInputStream());
                out = new DataOutputStream(cliente.getOutputStream() );
                out.writeUTF( strBuilder.toString());

                opcion = Integer.parseInt(receivingMessage(in));
                System.out.println("Opcion-> " + opcion);
                switch (opcion) {
                    case 1:
                        message = "|REGISTRAR EMPLEADO|\n" +
                                "Primer nombre:";
                        sendingMessage(message);
                        empleado.setEmplPrimerNombre(receivingMessage(in));
                        sendingMessage("Segundo nombre: ");
                        empleado.setEmplSegundoNombre(receivingMessage(in));
                        sendingMessage("Email: ");
                        empleado.setEmplEmail(receivingMessage(in));
                        sendingMessage("Fecha de nacimiento: ");
                        empleado.setEmplFechaNac(Date.valueOf(receivingMessage(in)));
                        sendingMessage("Sueldo: ");
                        empleado.setEmplSueldo(Integer.parseInt(receivingMessage(in)));
                        sendingMessage("Comision: ");
                        empleado.setEmplComision(Integer.parseInt(receivingMessage(in)));
                        sendingMessage("Cargo Id: ");
                        empleado.setEmplCargoId(Integer.parseInt(receivingMessage(in)));
                        sendingMessage("Gerente Id: ");
                        empleado.setEmplGerenteId(Integer.parseInt(receivingMessage(in)));
                        sendingMessage("Departamento Id: ");
                        empleado.setEmplDptoId(Integer.parseInt(receivingMessage(in)));
                        sendingMessage(String.valueOf(dao.createRecord(empleado)));
                        break;
                    case 2:
                        message = "|ACTUALIZAR EMPLEADO|\n" +
                                "Id del empleado: ";
                        sendingMessage(message);
                        IdEmpleado = Long.valueOf(receivingMessage(in));
                        sendingMessage("Primer nombre: ");
                        empleado.setEmplPrimerNombre(receivingMessage(in));
                        sendingMessage("Segundo nombre: ");
                        empleado.setEmplSegundoNombre(receivingMessage(in));
                        sendingMessage("Email: ");
                        empleado.setEmplEmail(receivingMessage(in));
                        sendingMessage("Fecha de nacimiento: ");
                        empleado.setEmplFechaNac(Date.valueOf(receivingMessage(in)));
                        sendingMessage("Sueldo: ");
                        empleado.setEmplSueldo(Integer.parseInt(receivingMessage(in)));
                        sendingMessage("Comision: ");
                        empleado.setEmplComision(Integer.parseInt(receivingMessage(in)));
                        sendingMessage("Cargo Id: ");
                        empleado.setEmplCargoId(Integer.parseInt(receivingMessage(in)));
                        sendingMessage("Gerente Id: ");
                        empleado.setEmplGerenteId(Integer.parseInt(receivingMessage(in)));
                        sendingMessage("Departamento Id: ");
                        empleado.setEmplDptoId(Integer.parseInt(receivingMessage(in)));
                        System.out.println("empleado " + empleado);
                        System.out.println("IdEmpleado " + IdEmpleado);
                        sendingMessage(String.valueOf(dao.updateRecord(empleado, IdEmpleado)));
                        break;
                    case 3:
                        sendingMessage("|ELIMINAR EMPLEADO|\n" +
                                "Id del empleado: ");
                        IdEmpleado = Long.valueOf(receivingMessage(in));
                        sendingMessage(String.valueOf(dao.deleteRecord(IdEmpleado)));
                        break;
                    case 4:
                        sendingMessage("|BUSCAR EMPLEADO|\n" +
                                "Id del empleado:");
                        IdEmpleado = Long.valueOf(receivingMessage(in));
                        sendingMessage(String.valueOf(dao.readRecord(IdEmpleado)));
                        break;
                    case 5:
                        sendingMessage("|LISTAR EMPLEADOS|");
                        empleados.clear();
                        empleados = dao.readRecords();
                        System.out.println("dao.readRecords()-> " + empleados);
                        sendingMessage(String.valueOf(empleados.size()));
                        System.out.println("empleados.size()-> " + empleados.size());

                        for (Empleado record : empleados) {
                            sendingMessage(record.toString());
                        }
                        break;
                    case 0:
                        sendingMessage("|SALIENDO...|");
                        break;
                    default:
                        sendingMessage("Opción no válida!");
                }

                if (opcion == 0) {
                    this.serverSocket.close();
                } else {
                    sendingMessage("¿Realizar otra acción? [1] Sí/[2] No");
                    opcion = Integer.parseInt(receivingMessage(in));
                    if (opcion != 1) {
                        this.serverSocket.close();
                        sendingMessage("|SALIENDO...|");
                    }
                }
            } while (!this.serverSocket.isClosed());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Show menu options
     * @return
     */
    public StringBuilder showMenu(){
        StringBuilder strBuilder =  new StringBuilder();
        strBuilder.append("*# GESTIÓN DE EMPLEADOS, POR FAVOR HACER SELECCIÓN #*\n");
        strBuilder.append("¿Qué acción quieres realizar?\n");
        strBuilder.append("[1] Crear registro\n"
                + "[2] Actualizar registro\n"
                + "[3] Eliminar registro\n"
                + "[4] Buscar un registro\n"
                + "[5] Mostrar todos los registros\n"
                + "[0] Salir");
        return strBuilder;
    }

    /**
     * Sending message using socket
     * @param message
     * @return
     */
    public String sendingMessage(String message) {
        try {
            out = new DataOutputStream(cliente.getOutputStream());
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
            return receiveMessage;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Main method to start socket server
     * @param args
     */
    public static void main(String[] args) {
        try {
            Server server = new Server(new ServerSocket(PUERTO));
            server.startServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}