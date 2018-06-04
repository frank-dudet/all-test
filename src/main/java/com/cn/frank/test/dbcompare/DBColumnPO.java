package com.cn.frank.test.dbcompare;

/**
 * Author: frank_du
 * Time : 2018/3/19 下午2:54
 */
public class DBColumnPO {

    String tableName;

    String columnName;

    String dataType;

    String defaultSetting;

    String nullAble;

    int maxLength;

    boolean isIdentity;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDefaultSetting() {
        return defaultSetting;
    }

    public void setDefaultSetting(String defaultSetting) {
        this.defaultSetting = defaultSetting;
    }

    public String getNullAble() {
        return nullAble;
    }

    public void setNullAble(String nullAble) {
        this.nullAble = nullAble;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public boolean isIdentity() {
        return isIdentity;
    }

    public void setIdentity(boolean identity) {
        isIdentity = identity;
    }
}
