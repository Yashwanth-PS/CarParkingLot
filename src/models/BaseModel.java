package models;

import java.time.LocalDateTime;

public class BaseModel {
    private int id;
    // Audit Columns --> Not for Business Requirement or Logical Use-case,
    // Instead it's for Auditing which can be done using Triggers in the DataBase
    private LocalDateTime createdAt;
    private LocalDateTime updatesAt;
    private String createdBy;
    private String updatedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatesAt() {
        return updatesAt;
    }

    public void setUpdatesAt(LocalDateTime updatesAt) {
        this.updatesAt = updatesAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
