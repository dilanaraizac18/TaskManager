package TaskManager.YaGanaste.RestController;

import TaskManager.YaGanaste.Entity.Repository.TaskDAOJPAImplementation;
import TaskManager.YaGanaste.Entity.Result;
import TaskManager.YaGanaste.Entity.Task;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tasks")
public class TaskRestController {

    @Autowired
    TaskDAOJPAImplementation taskDAOJPAImplementation;

    @GetMapping
    public ResponseEntity GetTasks() {

        Result result = new Result();

        result = taskDAOJPAImplementation.GetAll();

        if (result.correct) {

            if (result.objects != null || !result.objects.isEmpty()) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.noContent().build();
            }

        } else {
            return ResponseEntity.badRequest().body(result.errorMessage);
        }

    }

    @GetMapping("{IdTask}")
    public ResponseEntity GetById(@PathVariable("IdTask") int IdTask) {
        Result result = taskDAOJPAImplementation.GetById(IdTask);

        if (result.correct) {
            if (result.object != null) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().body(result.errorMessage);
        }

    }

    @DeleteMapping("{IdTask}")
    public ResponseEntity Delete(@PathVariable("IdTask") int IdTask) {

        Result result = taskDAOJPAImplementation.Delete(IdTask);

        if (result.correct) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result.errorMessage);
        }

    }

    @PostMapping()
    public ResponseEntity Add(@Valid @RequestBody Task task) {

        Result result = taskDAOJPAImplementation.Add(task);

        if (result.correct) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result.errorMessage);
        }

    }

    @PutMapping("/{IdTask}")
    public ResponseEntity Update(@Valid @RequestBody Task task, @PathVariable("IdTask") int IdTask) {
        Result result = taskDAOJPAImplementation.Update(task);

        if (result.correct) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result.errorMessage);

        }

    }

}
