package service;

import java.util.List;

import model.Assignment;
import repository.AssignmentRepository;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAssignmentsByAdminId(String adminId) {
        return assignmentRepository.findByAdminId(adminId);
    }

    public Assignment updateAssignmentStatus(String id, String status) {
        Assignment assignment = assignmentRepository.findById(id).orElseThrow();
        assignment.setStatus(status);
        return assignmentRepository.save(assignment);
    }
}
