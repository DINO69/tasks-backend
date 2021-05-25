package br.ce.wcaquino.taskbackend.suits;

import br.ce.wcaquino.taskbackend.controller.TaskControllerTest;
import br.ce.wcaquino.taskbackend.utils.DateUtilsTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({DateUtilsTest.class, TaskControllerTest.class})
public class RunAllTest {
}
