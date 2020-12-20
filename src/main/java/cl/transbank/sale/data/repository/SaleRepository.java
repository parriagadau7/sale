package cl.transbank.sale.data.repository;

import cl.transbank.sale.data.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findByCreatedBetween(LocalDateTime start, LocalDateTime end);
}
