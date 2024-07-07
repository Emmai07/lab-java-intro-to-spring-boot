package Repository;

import Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByAdmittingDoctor_Department(String department);

    // Custom query to find patients with doctors whose status is OFF
    @Query("SELECT p FROM Patient p WHERE p.admittingDoctor.status = 'OFF'")
    List<Patient> findPatientsWithDoctorsInStatusOff();
}
