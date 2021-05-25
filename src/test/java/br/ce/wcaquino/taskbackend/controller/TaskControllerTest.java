package br.ce.wcaquino.taskbackend.controller;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TaskControllerTest {

    @Mock
    private TaskRepo repo;

    @InjectMocks
    private TaskController controller;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = ValidationException.class)
    public void naoDeveSalvarTarefaSemDescricao() throws ValidationException {
        Task task = new Task();
        controller.save(task);
    }

    @Test
    public void naoDeveSalvarTarefaSemData() throws ValidationException {
        Task task = new Task();
        task.setTask("Descricao");

        expectedException.expectMessage("Fill the due date");
        expectedException.expect(ValidationException.class);

        controller.save(task);
    }

    @Test
    public void naoDeveSalvarTarefaComDataPassada() throws ValidationException {
        Task task = new Task();
        task.setTask("Descricao");
        task.setDueDate(LocalDate.of(2021,05,22));

        expectedException.expectMessage("Due date must not be in past");
        expectedException.expect(ValidationException.class);

        controller.save(task);
    }

    @Test
    public void naoDeveSalvarTarefaComDataPassadaComTry(){
        Task task = new Task();
        task.setTask("Descricao");
        task.setDueDate(LocalDate.of(2021,05,22));

        try {
            controller.save(task);
            Assert.fail();
        }catch (ValidationException e){
            Assert.assertEquals("Due date must not be in past",e.getMessage());
        }
    }

    @Test
    public void deveSalvarTarefa() throws ValidationException {
        Task task = new Task();
        task.setTask("Descricao");
        task.setDueDate(LocalDate.now());
        ArgumentCaptor<Task> argumentCaptor = ArgumentCaptor.forClass(Task.class);

        controller.save(task);

        Mockito.verify(repo).save(argumentCaptor.capture());

        Task taskSave = argumentCaptor.getValue();

        Assert.assertEquals(task.getTask(),taskSave.getTask());
        Assert.assertEquals(task.getDueDate(),taskSave.getDueDate());
        Assert.assertEquals(task,taskSave);

    }

    @Test
    public void deveSalvarTarefaComTaskNoResponseBody() throws ValidationException {
        Task task = new Task();
        task.setTask("Descricao");
        task.setDueDate(LocalDate.now());

        ArgumentCaptor<Task> argumentCaptor = ArgumentCaptor.forClass(Task.class);

        Mockito.when(repo.save(Mockito.anyObject())).thenReturn(task);

        ResponseEntity<Task> responseEntity = controller.save(task);

        Mockito.verify(repo).save(argumentCaptor.capture());

        Task taskSave = argumentCaptor.getValue();

        Task taskBodyResponse = responseEntity.getBody();

        Assert.assertEquals(task.getTask(),taskSave.getTask());
        Assert.assertEquals(task.getDueDate(),taskSave.getDueDate());
        Assert.assertEquals(task,taskSave);

        Assert.assertEquals(task.getTask(),taskBodyResponse.getTask());
        Assert.assertEquals(task.getDueDate(),taskBodyResponse.getDueDate());
        Assert.assertEquals(task,taskBodyResponse);

    }

    @Test
    public void findAllDeveSerChamadoNaClasseTaskRepo(){

        controller.findAll();
        Mockito.verify(repo,Mockito.times(1)).findAll();

    }

    @Test
    public void findAllDeveRetornarLista(){

        Mockito.when(repo.findAll()).thenReturn(Collections.EMPTY_LIST);
        List<Task> all = controller.findAll();

        Assert.assertEquals(0,all.size());
    }

    @Test
    public void findAllDeveRetornarListaComTask(){

        Task task = new Task();
        task.setTask("Descricao");
        task.setDueDate(LocalDate.now());

        Mockito.when(repo.findAll()).thenReturn(Collections.singletonList(task));
        List<Task> all = controller.findAll();

        Assert.assertEquals(1,all.size());
        Assert.assertEquals("Descricao",all.get(0).getTask());
        Assert.assertEquals(LocalDate.now(),all.get(0).getDueDate());
    }

}