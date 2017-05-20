package com.health.model.po;

public class FoodItem {
    private Integer programId;

    private String food;

    private String number;
    
    private Integer id;
    
    private Integer when;
    

    public Integer getWhen() {
		return when;
	}

	public void setWhen(Integer when) {
		this.when = when;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}