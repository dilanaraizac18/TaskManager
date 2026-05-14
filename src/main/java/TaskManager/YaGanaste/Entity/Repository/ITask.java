/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TaskManager.YaGanaste.Entity.Repository;

import TaskManager.YaGanaste.Entity.Result;
import TaskManager.YaGanaste.Entity.Task;


public interface ITask {
    Result GetAll();
    Result GetById(int idTask);
    Result Delete(int idTask);
    Result Add(Task task);
    
}
