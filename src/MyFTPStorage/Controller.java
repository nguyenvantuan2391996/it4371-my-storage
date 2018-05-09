/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyFTPStorage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author TuanNguyen
 */
public class Controller {

    /**
     * Lấy danh sách file
     *
     * @param folder : đường dẫn folder
     * @return : danhSach tên file có trong folder
     */
    public static ArrayList<String> getListFile(String folder) {
        ArrayList<String> danhSachFile = new ArrayList<String>();
        File dir = new File(folder);
        String[] children = dir.list();
        if (children == null) {
            System.out.println("Either dir does not exist or is not a directory");
        } else {
            for (int i = 0; i < children.length; i++) {
                danhSachFile.add(children[i]);
            }
        }
        return danhSachFile;
    }

    /**
     * Kiểm tra tồn tại của file
     *
     * @param name : tên file
     * @param folder : đường dẫn folder
     * @return true đã tồn tại và ngược lại
     */
    public static boolean checkExistFile(String name, String folder) {
        ArrayList<String> listFile = new ArrayList<>();
        listFile = Controller.getListFile(folder);

        for (String list : listFile) {
            if (name.equals(list)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Chia file thành 1 mảng byte
     *
     * @param file : file cần chia
     * @return buffer[] : mảng byte
     */
    public static byte[] splitFile(File file) {
        FileInputStream in = null;
        byte[] buffer = new byte[(int) file.length()];
        try {
            // chuyển file thành 1 mảng byte
            in = new FileInputStream(file);
            in.read(buffer);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * * ghép mảng byte thành 1 file
     *
     * @param buffer : mảng byte
     * @param sourceNameFile : đường dẫn lưu file
     * @return file : file ghép xong
     */
    public static File mergeFile(byte[] buffer, String sourceNameFile) {
        // ghi file ra thu muc Server
        File file = new File(sourceNameFile);
        FileOutputStream outFile = null;
        try {
            outFile = new FileOutputStream(file);
            outFile.write(buffer);
            outFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
}
