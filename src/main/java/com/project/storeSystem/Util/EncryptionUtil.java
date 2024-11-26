package com.project.storeSystem.Util;

import com.project.storeSystem.Entity.EncryptedInvoice;
import com.project.storeSystem.Entity.Invoice;

public class EncryptionUtil {

    public static EncryptedInvoice encryptedInvoiceItems(Invoice invoice) {
        EncryptedInvoice encryptedInvoice = new EncryptedInvoice();
        try{
            encryptedInvoice.setEncryptedSyskey((AESAlgorithm.encryptString(String.valueOf(invoice.getSyskey()))));
            encryptedInvoice.setEncryptedAutokey((AESAlgorithm.encryptString(String.valueOf(invoice.getAutokey()))));

            // String
            encryptedInvoice.setCreatedDate(AESAlgorithm.encryptString(invoice.getCreatedDate()));
            encryptedInvoice.setModifiedDate(AESAlgorithm.encryptString(invoice.getModifiedDate()));
            encryptedInvoice.setT1(AESAlgorithm.encryptString(invoice.getT1()));
            encryptedInvoice.setT2(AESAlgorithm.encryptString(invoice.getT2()));
            encryptedInvoice.setT3(AESAlgorithm.encryptString(invoice.getT3()));
            encryptedInvoice.setT4(AESAlgorithm.encryptString(invoice.getT4()));
            encryptedInvoice.setT5(AESAlgorithm.encryptString(invoice.getT5()));
            encryptedInvoice.setT6(AESAlgorithm.encryptString(invoice.getT6()));
            encryptedInvoice.setT7(AESAlgorithm.encryptString(invoice.getT7()));
            encryptedInvoice.setT8(AESAlgorithm.encryptString(invoice.getT8()));
            encryptedInvoice.setT9(AESAlgorithm.encryptString(invoice.getT9()));
            encryptedInvoice.setT10(AESAlgorithm.encryptString(invoice.getT10()));
            encryptedInvoice.setT11(AESAlgorithm.encryptString(invoice.getT11()));
            encryptedInvoice.setT12(AESAlgorithm.encryptString(invoice.getT12()));
            encryptedInvoice.setT13(AESAlgorithm.encryptString(invoice.getT13()));
            encryptedInvoice.setT14(AESAlgorithm.encryptString(invoice.getT14()));
            encryptedInvoice.setT15(AESAlgorithm.encryptString(invoice.getT15()));

            // Long
            encryptedInvoice.setN1((AESAlgorithm.encryptString(String.valueOf(invoice.getN1()))));
            encryptedInvoice.setN2((AESAlgorithm.encryptString(String.valueOf(invoice.getN2()))));
            encryptedInvoice.setN3((AESAlgorithm.encryptString(String.valueOf(invoice.getN3()))));
            encryptedInvoice.setN4((AESAlgorithm.encryptString(String.valueOf(invoice.getN4()))));
            encryptedInvoice.setN5((AESAlgorithm.encryptString(String.valueOf(invoice.getN5()))));
            encryptedInvoice.setN6((AESAlgorithm.encryptString(String.valueOf(invoice.getN6()))));
            encryptedInvoice.setN7((AESAlgorithm.encryptString(String.valueOf(invoice.getN7()))));
            encryptedInvoice.setN8((AESAlgorithm.encryptString(String.valueOf(invoice.getN8()))));
            encryptedInvoice.setN9((AESAlgorithm.encryptString(String.valueOf(invoice.getN9()))));
            encryptedInvoice.setN10((AESAlgorithm.encryptString(String.valueOf(invoice.getN10()))));

        } catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error Encrypting Invoice Items");
        }
        return encryptedInvoice;
    }
}
