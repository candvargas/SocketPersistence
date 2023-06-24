package org.poli.ingsoft.DAOs;

import org.poli.ingsoft.config.ConexionDB;
import org.poli.ingsoft.models.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpleadoDAO implements IDao<Empleado, Long> {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private boolean isSuccesfully = false;
    private Empleado empleado;
    private List<Empleado> empleados;

    private String[] QUERIES = {
            "INSERT INTO public.empleados (empl_primer_nombre, empl_segundo_nombre, empl_email, empl_fecha_nac," +
                    "empl_sueldo, empl_comision, empl_cargo_id, empl_gerente_id, empl_dpto_id) " +
                    "VALUES(?, ?, ?, ?," +
                    " ?, ?, ?, ?, ?);",
            "SELECT empl_id, empl_primer_nombre, empl_segundo_nombre, empl_email, empl_fecha_nac, empl_sueldo, " +
                    "empl_comision, empl_cargo_id, empl_gerente_id, empl_dpto_id " +
                    "FROM public.empleados WHERE empl_id = ?;",
            "UPDATE public.empleados\n" +
                    "SET empl_primer_nombre=?, empl_segundo_nombre=?, empl_email=?, empl_fecha_nac=?, " +
                    "empl_sueldo=?, empl_comision=?, empl_cargo_id=?, empl_gerente_id=?, empl_dpto_id=?\n" +
                    "WHERE empl_id=?;\n",
            "DELETE FROM public.empleados\n" +
                    "WHERE empl_id=?;\n",
            "SELECT * FROM public.empleados"
    };

    public EmpleadoDAO() {
        connection = ConexionDB.getInstance().getConnection();
        empleado = new Empleado();
        empleados = new ArrayList<>();
    }

    @Override
    public boolean createRecord(Empleado model) {
        try {
            preparedStatement = connection.prepareStatement(QUERIES[0]);
            preparedStatement.setString(1, model.getEmplPrimerNombre());
            preparedStatement.setString(2, model.getEmplSegundoNombre());
            preparedStatement.setString(3, model.getEmplEmail());
            preparedStatement.setDate(4, (Date) model.getEmplFechaNac());
            preparedStatement.setInt(5, model.getEmplSueldo());
            preparedStatement.setInt(6, model.getEmplComision());
            preparedStatement.setInt(7, model.getEmplCargoId());
            preparedStatement.setInt(8, model.getEmplGerenteId());
            preparedStatement.setInt(9, model.getEmplDptoId());

            System.out.println(preparedStatement);

            isSuccesfully = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return isSuccesfully;
    }

    @Override
    public Empleado readRecord(Long idModel) {
        try {
            preparedStatement = connection.prepareStatement(QUERIES[1]);
            preparedStatement.setLong(1, idModel);
            ResultSet data = preparedStatement.executeQuery();

            if (data.next()){
                empleado.setEmplId(data.getLong("empl_id"));
                empleado.setEmplPrimerNombre(data.getString("empl_primer_nombre"));
                empleado.setEmplSegundoNombre(data.getString("empl_segundo_nombre"));
                empleado.setEmplEmail(data.getString("empl_email"));
                empleado.setEmplFechaNac(data.getDate("empl_fecha_nac"));
                empleado.setEmplSueldo(data.getInt("empl_sueldo"));
                empleado.setEmplComision(data.getInt("empl_comision"));
                empleado.setEmplCargoId(data.getInt("empl_cargo_id"));
                empleado.setEmplGerenteId(data.getInt("empl_gerente_id"));
                empleado.setEmplDptoId(data.getInt("empl_dpto_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
            //Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return empleado;
    }

    @Override
    public boolean updateRecord(Empleado model, Long idModel) {
        try {
            preparedStatement = connection.prepareStatement(QUERIES[2]);
            preparedStatement.setString(1, model.getEmplPrimerNombre());
            preparedStatement.setString(2, model.getEmplSegundoNombre());
            preparedStatement.setString(3, model.getEmplEmail());
            preparedStatement.setDate(4, (Date) model.getEmplFechaNac());
            preparedStatement.setInt(5, model.getEmplSueldo());
            preparedStatement.setInt(6, model.getEmplComision());
            preparedStatement.setInt(7, model.getEmplCargoId());
            preparedStatement.setInt(8, model.getEmplGerenteId());
            preparedStatement.setInt(9, model.getEmplDptoId());
            preparedStatement.setLong(10, idModel);

            System.out.println(preparedStatement);

            isSuccesfully = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return isSuccesfully;
    }

    @Override
    public boolean deleteRecord(Long idModel) {
        try {
            preparedStatement = connection.prepareStatement(QUERIES[3]);
            preparedStatement.setLong(1, idModel);

            isSuccesfully = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isSuccesfully;
    }

    @Override
    public List<Empleado> readRecords() {
        try {
            preparedStatement = connection.prepareStatement(QUERIES[4]);
            ResultSet data = preparedStatement.executeQuery();

            while (data.next()) {
                empleados.add(new Empleado(
                        data.getLong("empl_id"),
                        data.getString("empl_primer_nombre"),
                        data.getString("empl_segundo_nombre"),
                        data.getString("empl_email"),
                        data.getDate("empl_fecha_nac"),
                        data.getInt("empl_sueldo"),
                        data.getInt("empl_comision"),
                        data.getInt("empl_cargo_id"),
                        data.getInt("empl_gerente_id"),
                        data.getInt("empl_dpto_id")
                        ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empleados;
    }
}
