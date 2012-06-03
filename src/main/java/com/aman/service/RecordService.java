package com.aman.service;

import java.util.List;

import com.aman.dao.RecordDao;
import com.aman.domain.Record;

public class RecordService {

    RecordDao recorddao;

    public RecordService() {
        recorddao = new RecordDao();
    }

    public void create(Record record) {
        recorddao.createRecord(record);
    }

    public List<Record> getList() {
        return recorddao.listRecord();
    }

}
