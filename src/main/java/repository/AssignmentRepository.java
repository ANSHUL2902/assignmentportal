package repository;

import java.util.List;

import model.Assignment;

public interface AssignmentRepository extends MongoRepository<Assignment, String> {
    List<Assignment> findByAdminId(String adminId);
}
