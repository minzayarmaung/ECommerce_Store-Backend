package com.project.storeSystem.Util;

import com.project.storeSystem.Entity.*;

public class EncryptionUtil {

    public static EncryptedPersonData encryptedPersonData(PersonData personData) {
        EncryptedPersonData encryptedPersonData = new EncryptedPersonData();
        try{
            encryptedPersonData.setEncryptedSyskey((AESAlgorithm.encryptString(String.valueOf(personData.getSyskey()))));
            encryptedPersonData.setEncryptedAutokey((AESAlgorithm.encryptString(String.valueOf(personData.getAutokey()))));

            // String
            encryptedPersonData.setCreatedDate(AESAlgorithm.encryptString(personData.getCreatedDate()));
            encryptedPersonData.setModifiedDate(AESAlgorithm.encryptString(personData.getModifiedDate()));
            encryptedPersonData.setT1(AESAlgorithm.encryptString(personData.getT1()));
            encryptedPersonData.setT2(AESAlgorithm.encryptString(personData.getT2()));
            encryptedPersonData.setT3(AESAlgorithm.encryptString(personData.getT3()));
            encryptedPersonData.setT4(AESAlgorithm.encryptString(personData.getT4()));
            encryptedPersonData.setT5(AESAlgorithm.encryptString(personData.getT5()));
            encryptedPersonData.setT6(AESAlgorithm.encryptString(personData.getT6()));
            encryptedPersonData.setT7(AESAlgorithm.encryptString(personData.getT7()));
            encryptedPersonData.setT8(AESAlgorithm.encryptString(personData.getT8()));
            encryptedPersonData.setT9(AESAlgorithm.encryptString(personData.getT9()));
            encryptedPersonData.setT10(AESAlgorithm.encryptString(personData.getT10()));
            encryptedPersonData.setT11(AESAlgorithm.encryptString(personData.getT11()));
            encryptedPersonData.setT12(AESAlgorithm.encryptString(personData.getT12()));
            encryptedPersonData.setT13(AESAlgorithm.encryptString(personData.getT13()));
            encryptedPersonData.setT14(AESAlgorithm.encryptString(personData.getT14()));
            encryptedPersonData.setT15(AESAlgorithm.encryptString(personData.getT15()));

            // Long
            encryptedPersonData.setN1((AESAlgorithm.encryptString(String.valueOf(personData.getN1()))));
            encryptedPersonData.setN2((AESAlgorithm.encryptString(String.valueOf(personData.getN2()))));
            encryptedPersonData.setN3((AESAlgorithm.encryptString(String.valueOf(personData.getN3()))));
            encryptedPersonData.setN4((AESAlgorithm.encryptString(String.valueOf(personData.getN4()))));
            encryptedPersonData.setN5((AESAlgorithm.encryptString(String.valueOf(personData.getN5()))));
            encryptedPersonData.setN6((AESAlgorithm.encryptString(String.valueOf(personData.getN6()))));
            encryptedPersonData.setN7((AESAlgorithm.encryptString(String.valueOf(personData.getN7()))));
            encryptedPersonData.setN8((AESAlgorithm.encryptString(String.valueOf(personData.getN8()))));
            encryptedPersonData.setN9((AESAlgorithm.encryptString(String.valueOf(personData.getN9()))));
            encryptedPersonData.setN10((AESAlgorithm.encryptString(String.valueOf(personData.getN10()))));

        } catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error Encrypting Invoice Items");
        }
        return encryptedPersonData;
    }

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

    public static EncryptedStock encryptedStockItems(Stock stock) {
        EncryptedStock encryptedItem = new EncryptedStock();
        try{
            encryptedItem.setEncryptedSyskey((AESAlgorithm.encryptString(String.valueOf(stock.getSyskey()))));
            encryptedItem.setEncryptedAutokey((AESAlgorithm.encryptString(String.valueOf(stock.getAutokey()))));

            // String
            encryptedItem.setCreatedDate(AESAlgorithm.encryptString(stock.getCreatedDate()));
            encryptedItem.setModifiedDate(AESAlgorithm.encryptString(stock.getModifiedDate()));
            encryptedItem.setT1(AESAlgorithm.encryptString(stock.getT1()));
            encryptedItem.setT2(AESAlgorithm.encryptString(stock.getT2()));
            encryptedItem.setT3(AESAlgorithm.encryptString(stock.getT3()));
            encryptedItem.setT4(AESAlgorithm.encryptString(stock.getT4()));
            encryptedItem.setT5(AESAlgorithm.encryptString(stock.getT5()));
            encryptedItem.setT6(AESAlgorithm.encryptString(stock.getT6()));
            encryptedItem.setT7(AESAlgorithm.encryptString(stock.getT7()));
            encryptedItem.setT8(AESAlgorithm.encryptString(stock.getT8()));
            encryptedItem.setT9(AESAlgorithm.encryptString(stock.getT9()));
            encryptedItem.setT10(AESAlgorithm.encryptString(stock.getT10()));
            encryptedItem.setT11(AESAlgorithm.encryptString(stock.getT11()));
            encryptedItem.setT12(AESAlgorithm.encryptString(stock.getT12()));
            encryptedItem.setT13(AESAlgorithm.encryptString(stock.getT13()));
            encryptedItem.setT14(AESAlgorithm.encryptString(stock.getT14()));
            encryptedItem.setT15(AESAlgorithm.encryptString(stock.getT15()));

            // Long
            encryptedItem.setN1((AESAlgorithm.encryptString(String.valueOf(stock.getN1()))));
            encryptedItem.setN2((AESAlgorithm.encryptString(String.valueOf(stock.getN2()))));
            encryptedItem.setN3((AESAlgorithm.encryptString(String.valueOf(stock.getN3()))));
            encryptedItem.setN4((AESAlgorithm.encryptString(String.valueOf(stock.getN4()))));
            encryptedItem.setN5((AESAlgorithm.encryptString(String.valueOf(stock.getN5()))));
            encryptedItem.setN6((AESAlgorithm.encryptString(String.valueOf(stock.getN6()))));
            encryptedItem.setN7((AESAlgorithm.encryptString(String.valueOf(stock.getN7()))));
            encryptedItem.setN8((AESAlgorithm.encryptString(String.valueOf(stock.getN8()))));
            encryptedItem.setN9((AESAlgorithm.encryptString(String.valueOf(stock.getN9()))));
            encryptedItem.setN10((AESAlgorithm.encryptString(String.valueOf(stock.getN10()))));

        } catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error Encrypting Invoice Items");
        }
        return encryptedItem;
    }
}
