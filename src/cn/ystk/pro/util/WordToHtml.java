package cn.ystk.pro.util;
import java.io.File;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
public class WordToHtml {
     int WORD_HTML = 8;
     int WORD_TXT = 7;
     int EXCEL_HTML = 44;
   /**
    * 
    * 功能：wordToHtml
    * @param docfile
    * @param htmlfile
    */
    public void wordToHtml(String docfile, String htmlfile) {
        ActiveXComponent app = new ActiveXComponent("Word.Application.11"); // ����word
        try {
             app.setProperty("Visible", new Variant(false));
            Dispatch docs = app.getProperty("Documents").toDispatch();
            Dispatch doc = Dispatch.invoke(
                     docs,
                     "Open",
                    Dispatch.Method,
                    new Object[] { docfile, new Variant(false),
                             new Variant(true) }, new int[1]).toDispatch();
            Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {
                     htmlfile, new Variant(WORD_HTML) }, new int[1]);
            Variant f = new Variant(false);
             Dispatch.call(doc, "Close", f);
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
            app.invoke("Quit", new Variant[] {});
         }
     }

     /**
      * 
      * 功能：exceltohtml
      * @param xlsfile
      * @param htmlfile
      */
     public void excelToHtml(String xlsfile, String htmlfile) {
         ActiveXComponent app = new ActiveXComponent("Excel.Application"); // ����excel
         try {
             app.setProperty("Visible", new Variant(false));
             Dispatch excels = app.getProperty("Workbooks").toDispatch();
            Dispatch excel = Dispatch.invoke(
                     excels,
                      "Open",
                      Dispatch.Method,
                      new Object[] { xlsfile, new Variant(false),
                              new Variant(true) }, new int[1]).toDispatch();
              Dispatch.invoke(excel, "SaveAs", Dispatch.Method, new Object[] {
                      htmlfile, new Variant(EXCEL_HTML) }, new int[1]);
             Variant f = new Variant(false);
             Dispatch.call(excel, "Close", f);
             System.out.println("wordtohtmlת���ɹ�");
         } catch (Exception e) {
              e.printStackTrace();
         } finally {
            app.invoke("Quit", new Variant[] {});
         }
      }
     /**
      * 
      * 功能：文件夹路径
      * @param folderPath
      */
     public void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); 
             String filePath = folderPath;
            filePath = filePath.toString();
             java.io.File myFilePath = new java.io.File(filePath);
             myFilePath.delete(); 
         } catch (Exception e) {
            e.printStackTrace();
         }
    }

    /**
     * 
     * 功能：
     * @param path
     * @return
     */
    public boolean delAllFile(String path) {
        boolean flag = false;
         File file = new File(path);
        if (!file.exists()) {
            return flag;
         }
         if (!file.isDirectory()) {
             return flag;
         }
         String[] tempList = file.list();
         File temp = null;
         for (int i = 0; i < tempList.length; i++) {
             if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
             } else {
                 temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                 temp.delete();
             }
             if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);// ��ɾ���ļ���������ļ�
                 delFolder(path + "/" + tempList[i]);// ��ɾ����ļ���
                flag = true;
             }
        }
        return flag;
    }
 
     public static void main(String[] args) {
         // TODO Auto-generated method stub
         WordToHtml wordtohtml = new WordToHtml();
        wordtohtml.wordToHtml("c:\\bb.doc","D:\\test.html");
         System.out.println("wordתhtml�ɹ�");
     }
 }



/*报错：Can't get object clsid from progid
原因： ActiveXComponent app = new ActiveXComponent("Word.Application"); // 启动word
       这段代码中的word.Application书写错误，要到注册表中HKEY_CLASSES_ROOT目录下查找word.Application
       应该写word.Application.11
报错：Exception in thread "main" java.lang.UnsatisfiedLinkError: no jacob-1.18-M2-x86 in java.library.path
原因：没有把jacob-1.18-M2-x86.dll拷贝到jdk/bin文件中

将word转化为html的步骤
1.下载jacob.jar包和jacob-1.18-M2-x86.dll文件
2.将jacob.jar包添加到myeclipse中，
3.将jacob-1.18-M2-x86.dll复制到jdk/bin文件夹中*/