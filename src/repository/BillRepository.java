package repository;

import exception.BillNotFoundException;
import models.Bill;

import java.util.HashMap;
import java.util.Map;

public class BillRepository {
    private Map<Integer, Bill> billMap;

    public BillRepository() {
        this.billMap = new HashMap<>();
    }

    public Bill get(int billId) {
        Bill bill = billMap.get(billId);
        if (bill == null) {
            throw new BillNotFoundException("Bill not found for : " + billId);
        }
        return bill;
    }

    public void put(Bill bill) {
        billMap.put(bill.getId(), bill);
    }
}