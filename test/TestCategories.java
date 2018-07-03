import framework.Configuration;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LoginPage;


public class TestCategories {
    
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static CategoriesPage categoriesPage;
    
    public TestCategories() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        Configuration.init();
        loginPage = new LoginPage();
        dashboardPage = loginPage.logIn();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        categoriesPage = dashboardPage.goToCategories();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreateNewCategory() {
        categoriesPage.addNewCategoy();
    }
}
