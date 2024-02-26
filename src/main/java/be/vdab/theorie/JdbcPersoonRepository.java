package be.vdab.theorie;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersoonRepository extends AbstractRepository implements PersoonRepository{

    @Override
    public List<BigDecimal> findAllWeddes() {
        var weddes = new ArrayList<BigDecimal>();
        var sql = """
        select wedde
        from personen
        """;
        try (var connection = super.getConnection();
             var statement = connection.prepareStatement(sql)) {
            connection.setTransactionIsolation(
                    Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            for (var result = statement.executeQuery(); result.next(); ) {
                weddes.add(result.getBigDecimal("wedde"));
            }
            connection.commit();
            return weddes;
        } catch(SQLException ex) {
            throw new RepositoryException(ex);
        }
    }

}
