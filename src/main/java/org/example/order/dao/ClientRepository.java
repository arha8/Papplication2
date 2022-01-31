package org.example.order.dao;

import org.example.order.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT cl FROM Client cl WHERE cl.firstName = :firstName AND " +
            "cl.lastName = :lastName AND cl.patronymic = :patronymic AND " +
            "cl.dateOfBirth = :dateOfBirth")
    List<Client> findClient(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("patronymic") String patronymic,
            @Param("dateOfBirth") LocalDate dateOfBirth
    );
}
