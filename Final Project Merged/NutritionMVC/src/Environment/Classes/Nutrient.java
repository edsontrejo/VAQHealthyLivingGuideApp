/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Classes;

/**
 *
 * @author MQ0162246
 */
public class Nutrient implements Comparable<Nutrient>{
	//image_name;food_name;food_group;serving;calories;total_fat;cholesterol;sodium;potassium;carbohydrates;proteins
	private String image;
        private String name;
	private String category;    // proteins, fats, grains, dairy, etc.
	private String categoryId;  
	private String servinUnit;  // grams
	private double baseCalories; // per bas portion
        private double baseTotalFat;
        private double baseCholestrol;
        private double baseSodium;
        private double basePotassium;
        private double baseCarbohydrates;
        private double baseProteins;
	private double basePortion;  // base portion
	private double actualPortion; // actual increase/decrease to meet calories
	private double actualCalories; // actual calories based on actual portion
        private double actualTotalFat;
        private double actualCholestrol;
        private double actualSodium;
        private double actualPotassium;
        private double actualCarbohydrates;
        private double actualProteins;

    @Override
    public String toString() {
        return (name);
    }

	
	// others as needed

	public Nutrient(String image, String name, String category, String categoryId, String servinUnit, 
                        double baseCalories, double basePortion, double baseTotalFat, double baseCholesterol,
                        double baseSodium, double basePotassium, double baseCarbohydrates, double baseProteins) 
        {
		//image_name;food_name;food_group;serving;calories;total_fat;cholesterol;sodium;potassium;carbohydrates;proteins
                this.image = image;
                this.name = name;
		this.category = category;
		this.categoryId = categoryId;
		this.servinUnit = servinUnit;
		this.basePortion = basePortion;
                this.baseCalories = baseCalories;
                this.baseTotalFat = baseTotalFat;
                this.baseCholestrol = baseCholesterol;
                this.baseSodium = baseSodium;
                this.basePotassium = basePotassium;
                this.baseCarbohydrates = baseCarbohydrates;
                this.baseProteins = baseProteins;
    
                //Actual 
                this.actualPortion = this.basePortion;
                this.actualCalories = this.baseCalories;
                this.actualTotalFat = this.baseTotalFat;
                this.actualCholestrol = this.baseCholestrol;
                this.actualSodium = this.baseSodium;
                this.actualPotassium = this.basePotassium;
                this.actualCarbohydrates = this.baseCarbohydrates;
                this.actualProteins = this.baseProteins;
               
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the unit
	 */

	/**
	 * @return the portion
	 */
	public double getPortion() {
		return basePortion;
	}

	/**
	 * @param portion the portion to set
	 */
	public void setPortion(double portion) {
		this.basePortion = portion;
	}

	/**
	 * @return the actualPortion
	 */
	public double getActualPortion() {
		return actualPortion;
	}

	/**
	 * @param actualPortion the actualPortion to set
	 */
	public void setActualPortion(double actualPortion) {
		this.actualPortion = actualPortion;
	}



	/**
	 * @param servinUnit the servinUnit to set
	 */
	public void setServinUnit(double servinUnit) {
            this.setServinUnit(servinUnit);
	}

	/**
	 * @return the baseCalories
	 */
	public double getBaseCalories() {
		return baseCalories;
	}

	/**
	 * @param baseCalories the baseCalories to set
	 */
	public void setBaseCalories(double baseCalories) {
		this.baseCalories = baseCalories;
	}

	/**
	 * @return the basePortion
	 */
	public double getBasePortion() {
		return basePortion;
	}

	/**
	 * @param basePortion the basePortion to set
	 */
	public void setBasePortion(double basePortion) {
		this.basePortion = basePortion;
	}

	/**
	 * @return the actualCalories
	 */
	public double getActualCalories() {
		return actualCalories;
	}

	/**
	 * @param actualCalories the actualCalories to set
	 */
	public void setActualCalories(double actualCalories) {
		this.actualCalories = actualCalories;
	}

	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

    /**
     * @param servinUnit the servinUnit to set
     */
    public void setServinUnit(String servinUnit) {
        this.servinUnit = servinUnit;
    }

    /**
     * @return the servinUnit
     */
    public String getServinUnit() {
        return servinUnit;
    }
    
     /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the baseTotalFat
     */
    public double getBaseTotalFat() {
        return baseTotalFat;
    }

    /**
     * @param baseTotalFat the baseTotalFat to set
     */
    public void setBaseTotalFat(double baseTotalFat) {
        this.baseTotalFat = baseTotalFat;
    }

    /**
     * @return the baseCholestrol
     */
    public double getBaseCholestrol() {
        return baseCholestrol;
    }

    /**
     * @param baseCholestrol the baseCholestrol to set
     */
    public void setBaseCholestrol(double baseCholestrol) {
        this.baseCholestrol = baseCholestrol;
    }

    /**
     * @return the baseSodium
     */
    public double getBaseSodium() {
        return baseSodium;
    }

    /**
     * @param baseSodium the baseSodium to set
     */
    public void setBaseSodium(double baseSodium) {
        this.baseSodium = baseSodium;
    }

    /**
     * @return the basePotassium
     */
    public double getBasePotassium() {
        return basePotassium;
    }

    /**
     * @param basePotassium the basePotassium to set
     */
    public void setBasePotassium(double basePotassium) {
        this.basePotassium = basePotassium;
    }

    /**
     * @return the baseCarbohydrates
     */
    public double getBaseCarbohydrates() {
        return baseCarbohydrates;
    }

    /**
     * @param baseCarbohydrates the baseCarbohydrates to set
     */
    public void setBaseCarbohydrates(double baseCarbohydrates) {
        this.baseCarbohydrates = baseCarbohydrates;
    }

    /**
     * @return the baseProteins
     */
    public double getBaseProteins() {
        return baseProteins;
    }

    /**
     * @param baseProteins the baseProteins to set
     */
    public void setBaseProteins(double baseProteins) {
        this.baseProteins = baseProteins;
    }

    /**
     * @return the actualTotalFat
     */
    public double getActualTotalFat() {
        return actualTotalFat;
    }

    /**
     * @param actualTotalFat the actualTotalFat to set
     */
    public void setActualTotalFat(double actualTotalFat) {
        this.actualTotalFat = actualTotalFat;
    }

    /**
     * @return the actualCholestrol
     */
    public double getActualCholestrol() {
        return actualCholestrol;
    }

    /**
     * @param actualCholestrol the actualCholestrol to set
     */
    public void setActualCholestrol(double actualCholestrol) {
        this.actualCholestrol = actualCholestrol;
    }

    /**
     * @return the actualSodium
     */
    public double getActualSodium() {
        return actualSodium;
    }

    /**
     * @param actualSodium the actualSodium to set
     */
    public void setActualSodium(double actualSodium) {
        this.actualSodium = actualSodium;
    }

    /**
     * @return the actualPotassium
     */
    public double getActualPotassium() {
        return actualPotassium;
    }

    /**
     * @param actualPotassium the actualPotassium to set
     */
    public void setActualPotassium(double actualPotassium) {
        this.actualPotassium = actualPotassium;
    }

    /**
     * @return the actualCarbohydrates
     */
    public double getActualCarbohydrates() {
        return actualCarbohydrates;
    }

    /**
     * @param actualCarbohydrates the actualCarbohydrates to set
     */
    public void setActualCarbohydrates(double actualCarbohydrates) {
        this.actualCarbohydrates = actualCarbohydrates;
    }

    /**
     * @return the actualProteins
     */
    public double getActualProteins() {
        return actualProteins;
    }

    /**
     * @param actualProteins the actualProteins to set
     */
    public void setActualProteins(double actualProteins) {
        this.actualProteins = actualProteins;
    }

    @Override
    public int compareTo(Nutrient o) {
        
        return category.compareTo(o.getCategory());
    }	
}