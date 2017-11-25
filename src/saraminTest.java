
 
import java.util.List;
import java.util.concurrent.TimeUnit;
 
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
 
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
 
public class saraminTest {
    private static WebDriver driver;
    String Title = null;
    String URL = null;
    String alertText = "";
 
    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C://UISpace//crawling//chromedriver.exe"); //ũ�� ����̹� ���� ��μ���
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //����ð� 5�ʼ���
        driver.get("https://www.saramin.co.kr/zf_user/auth?url=%2Fzf_user%2F");  //������ ����Ʈ
    }
 
    @Test
    public void Step_01_������_�α���_Test () throws Exception {
         
    	driver.findElement(By.name("id")).sendKeys("chlgudrbdn");  //ID
    	driver.findElement(By.name("password")).sendKeys("m6529194!"); //���
        driver.findElement(By.className("btn-login")).click(); //�α��� ��ư Ŭ��
 
    }
    @Test
    public void Step_02_�ӽ�����_Test () throws Exception {
         
         
        for(String Handle : driver.getWindowHandles())  //��â���� ����Ī
            driver.switchTo().window(Handle);
        driver.findElement(By.xpath("//*[@id='main_top_2']/div[1]/fieldset[1]/div/a/img")).click();//�����ϱ� Ŭ��
         
        driver.switchTo().frame("editor");  //�����ϱ� �Է�â iframe���� ����Ī
         
        driver.findElement(By.xpath("//*[@id='title']")).sendKeys("����������"); //�����Է�
        driver.switchTo().frame("SmartEditorIframe");                       //�����Է� â iframe ����Ī
        driver.findElement(By.cssSelector("body")).sendKeys("���̻��");        //�����Է�
         
        driver.switchTo().defaultContent();                                 //����Ī �ʱ�ȭ
        //�ٽ� �����ϱ� â iframe ����Ī
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='editor']")));
         
         
         
        driver.findElement(By.xpath("//*[@id='au_submit_button']/div[2]/a[1]/img")).click();  //�ӽ����� Ŭ��
         
        String num = driver.findElement(By.id("temporary_save_count")).getText();   //���� �ӽ����� �� �� ī��Ʈ ����
         
        Thread.sleep(1000);     //�ʹ� ���� �� â ������ �ȵǴ� �� �����ϱ� ���� ���� �߰�
         
        Alert alert = driver.switchTo().alert();            //�� â���� ����Ī
        alertText = alert.getText();                        //�� â �޽��� ����
        alert.accept();                                     //�� â Ȯ�� Ŭ��
        System.out.println(alertText);                      //��� â �޽��� ���
         
        Thread.sleep(1000);
         
        System.out.println("�ӽ����� �� ���� : "+num);
         
        driver.findElement(By.xpath("//*[@id='title']")).clear();       //���� ���� ����
        driver.findElement(By.xpath("//*[@id='title']")).sendKeys("���̺�Ľ����쿡��"); //���� �ٽ� �Է�
                 
         
         
        driver.switchTo().frame("SmartEditorIframe");                   //���� �Է� â iframe ����Ī
        driver.findElement(By.cssSelector("body")).sendKeys("����ĥ��");    //�����Է�
        driver.switchTo().defaultContent();                             //â ����Ī �ʱ�ȭ
        //�ٽ� �����ϱ� â iframe ����Ī
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='editor']")));
         
        Thread.sleep(1000);
         
 
    }
     
    @Test
    public void Step_03_�����ܰ�_Test () throws Exception {
        driver.findElement(By.xpath("//img[@alt='�����ܰ�']")).click(); //�����ܰ� ��ư Ŭ��
         
        //ī�װ�
        Thread.sleep(1000);
        driver.findElement(By.linkText("���丮 ���� ����")).click();  //���丮 �������� Ŭ��
         
         
        Select dropdown = new Select(driver.findElement(By.id("choose_dir_d1")));  //ù��° ���� �ڽ��� ������
        dropdown.deselectAll();                 //���� ��� �ʱ�ȭ
        dropdown.selectByValue("1");            //value 1�� ���� ����
         
         
        dropdown = new Select(driver.findElement(By.id("choose_dir_d2")));      //�ι�° �����ڽ� ������
        dropdown.deselectAll();                                                 //���� ����
        dropdown.selectByValue("101");     
         
        dropdown = new Select(driver.findElement(By.id("choose_dir_d3")));
        dropdown.deselectAll();
        dropdown.selectByValue("10103");
         
        dropdown = new Select(driver.findElement(By.id("choose_dir_d4")));
        dropdown.deselectAll();
        dropdown.selectByValue("1010303");
         
        Thread.sleep(1000);
         
        driver.switchTo().defaultContent();             //â ����Ī �ʱ�ȭ
        //�����ϱ� â iframe ����Ī
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='editor']")));
        driver.findElement(By.xpath("//*[@id='au_submit_button2']/div[2]/a[1]/img")).click();//�ӽ����� Ŭ��
         
        Thread.sleep(3000);
         
        Alert alert = driver.switchTo().alert();        //�� â ����Ī
        alertText = alert.getText();
        alert.accept();                                 //�� Ȯ�� Ŭ��
        System.out.println("�ٸ��������� "+alertText);
         
        String num = driver.findElement(By.id("temporary_save_count")).getText();  //�ӽ����� ī��Ʈ ����
        System.out.println("�ӽ����� �� ���� : "+num);
         
         
         
 
    }
     
    @Test
    public void Step_04_����_��_�ӽ�����_����_Test () throws Exception {
         
        // �ӽ����� â
        driver.findElement(By.className("_tempsave_open_close")).click();   //�ӽ����� �� Ŭ��
 
        driver.switchTo().defaultContent();                                 //â �ʱ�ȭ
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='editor']"))); //�����ϱ� iframe â ����Ī
 
        String info = driver.findElement(By.className("info_tempsave")).getText(); //�ӽ����� â �ȳ� �� ����
        System.out.println("�ӽ����� â " + info);
 
        WebElement tempList = driver.findElement(By.className("tempsave_list")); //�ӽ����� �� ��� ������
        List<WebElement> list = tempList.findElements(By.className("q_on"));      //����� ����Ʈ�� �־��
 
        //���� ���̴ϱ� 2��°�� 1�� ��� ���� ��ư�� Ŭ��
        list.get(1).findElement(By.tagName("img")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();            //���� Ȯ�� �� â
        alertText = alert.getText();
        alert.accept();                                     //Ȯ�� Ŭ��
        System.out.println("����" + alertText);
 
         
         
    }
     
    @Test
    public void Step_05_�ӽ�����_����_Test () throws Exception {
        /*******���� �� ������ ����*******/
        driver.switchTo().defaultContent();                            
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='editor']")));
 
        WebElement tempList1 = driver.findElement(By.className("tempsave_list"));
        List<WebElement> list1 = tempList1.findElements(By.className("q_on"));
 
        //���⼭ ����� ������ ���� 1��°�� 0��° ��� ������ư Ŭ��
        list1.get(0).findElement(By.tagName("img")).click();   
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alertText = alert.getText();
        alert.accept();
        System.out.println(alertText);
 
        Thread.sleep(1000);
 
        String num = driver.findElement(By.id("temporary_save_count")).getText();
        System.out.println("�ӽ����� �� ���� : " + num);
 
        Thread.sleep(1000);
         
         
    }
     
     
 
    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
 
}


//��ó: http://yonoo88.tistory.com/603 [yonoo's]