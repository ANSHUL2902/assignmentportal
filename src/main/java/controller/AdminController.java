package controller;

import java.util.List;

import model.Assignment;
import service.AssignmentService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/assignments")
    public List<Assignment> getAssignments(@RequestParam String adminId) {
        return assignmentService.getAssignmentsByAdminId(adminId);
    }

    @PostMapping("/assignments/{id}/accept")
    public Assignment acceptAssignment(@PathVariable String id) {
        return assignmentService.updateAssignmentStatus(id, "ACCEPTED");
    }

    @PostMapping("/assignments/{id}/reject")
    public Assignment rejectAssignment(@PathVariable String id) {
        return assignmentService.updateAssignmentStatus(id, "REJECTED");
    }
}
