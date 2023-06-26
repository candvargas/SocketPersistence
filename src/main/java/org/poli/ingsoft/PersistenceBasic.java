package org.poli.ingsoft;

import org.poli.ingsoft.DAOs.DaoFactory;
import org.poli.ingsoft.DAOs.IDao;
import org.poli.ingsoft.config.ConexionDB;
import org.poli.ingsoft.models.Empleado;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersistenceBasic {
    public static void main(String[] args) {
        ConexionDB.getInstance();
        try {
            Empleado empleado = new Empleado();

            IDao dao = DaoFactory.getDao(DaoFactory.DaoType.EMPLEADO);

            List<Empleado> empleados = new ArrayList<>();

            Scanner sc = new Scanner(System.in);
            int opcion;
            Long IdEmpleado;
            boolean repetir = true;

            do {
                System.out.println("*# GESTIÓN DE EMPLEADOS, POR FAVOR HACER SELECCIÓN #*");
                System.out.println("¿Qué acción quieres realizar?");
                System.out.println("[1] Crear registro\n"
                        + "[2] Actualizar registro\n"
                        + "[3] Eliminar registro\n"
                        + "[4] Buscar un registro\n"
                        + "[5] Mostrar todos los registros\n"
                        + "[0] Salir");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("|REGISTRAR EMPLEADO|");
                        System.out.println("Primer nombre: ");
                        empleado.setEmplPrimerNombre(sc.next());
                        System.out.println("Segundo nombre: ");
                        empleado.setEmplSegundoNombre(sc.next());
                        System.out.println("Email: ");
                        empleado.setEmplEmail(sc.next());
                        System.out.println("Fecha de nacimiento: ");
                        empleado.setEmplFechaNac(Date.valueOf(sc.next()));
                        System.out.println("Sueldo: ");
                        empleado.setEmplSueldo(sc.nextInt());
                        System.out.println("Comision: ");
                        empleado.setEmplComision(sc.nextInt());
                        System.out.println("Cargo Id: ");
                        empleado.setEmplCargoId(sc.nextInt());
                        System.out.println("Gerente Id: ");
                        empleado.setEmplGerenteId(sc.nextInt());
                        System.out.println("Departamento Id: ");
                        empleado.setEmplDptoId(sc.nextInt());
                        System.out.println(dao.createRecord(empleado));
                        break;
                    case 2:
                        System.out.println("|ACTUALIZAR EMPLEADO|");
                        System.out.println("Id del empleado: ");
                        IdEmpleado = sc.nextLong();
                        System.out.println("Primer nombre: ");
                        empleado.setEmplPrimerNombre(sc.next());
                        System.out.println("Segundo nombre: ");
                        empleado.setEmplSegundoNombre(sc.next());
                        System.out.println("Email: ");
                        empleado.setEmplEmail(sc.next());
                        System.out.println("Fecha de nacimiento: ");
                        empleado.setEmplFechaNac(Date.valueOf(sc.next()));
                        System.out.println("Sueldo: ");
                        empleado.setEmplSueldo(sc.nextInt());
                        System.out.println("Comision: ");
                        empleado.setEmplComision(sc.nextInt());
                        System.out.println("Cargo Id: ");
                        empleado.setEmplCargoId(sc.nextInt());
                        System.out.println("Gerente Id: ");
                        empleado.setEmplGerenteId(sc.nextInt());
                        System.out.println("Departamento Id: ");
                        empleado.setEmplDptoId(sc.nextInt());
                        System.out.println(dao.updateRecord(empleado, IdEmpleado));
                        break;
                    case 3:
                        System.out.println("|ELIMINAR EMPLEADO|");
                        System.out.println("Id del empleado: ");
                        IdEmpleado = sc.nextLong();
                        System.out.println(dao.deleteRecord(IdEmpleado));
                        break;
                    case 4:
                        System.out.println("|BUSCAR EMPLEADO|");
                        System.out.println("Id del empleado: ");
                        IdEmpleado = sc.nextLong();
                        dao.readRecord(IdEmpleado);
                        System.out.println(dao.readRecord(IdEmpleado));
                        break;
                    case 5:
                        System.out.println("|LISTAR EMPLEADOS|");
                        empleados.clear();
                        empleados = dao.readRecords();
                        for (Empleado record : empleados) {
                            System.out.println(record.toString());
                        }
                        break;
                    case 0:
                        System.out.println("|SALIENDO...|");
                        break;
                    default:
                        System.out.println("Opción no válida!");
                }

                if (opcion == 0) {
                    repetir = false;
                } else {
                    System.out.println("¿Realizar otra acción? [1] Sí/[2] No");
                    opcion = sc.nextInt();
                    if (opcion != 1) {
                        repetir = false;
                        System.out.println("|SALIENDO...|");
                    }
                }
            } while (repetir);


        } catch (Exception e) {
            System.err.println(e);
        }
    }
}