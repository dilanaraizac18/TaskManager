/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskManager.YaGanaste.RestController;

import TaskManager.YaGanaste.Entity.Repository.TaskDAOJPAImplementation;
import TaskManager.YaGanaste.Entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tasks")
public class TaskRestController {

    @Autowired
    TaskDAOJPAImplementation taskDAOJPAImplementation;

    @GetMapping
    public ResponseEntity GetTasks() {

        Result result = new Result();

        try {

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

        } catch (Exception ex) {
            return ResponseEntity.status(500).body(ex);
        }

    }

    @GetMapping("{IdTask}")
    public ResponseEntity GetById(@PathVariable("IdTask") int IdTask) {
        try {
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

        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }

    @DeleteMapping("{IdTask}")
    public ResponseEntity Delete(@PathVariable("IdTask") int IdTask) {

        try {

            Result result = taskDAOJPAImplementation.Delete(IdTask);

            if (result.correct) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.badRequest().body(result.errorMessage);
            }

        } catch (Exception ex) {
            return ResponseEntity.status(500).body(ex);
        }
    }
}
