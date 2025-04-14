package enums;

/**
 * 枚举类型示例
 */
public enum Season {
    SPRING("春天", 15),
    SUMMER("夏天", 30),
    AUTUMN("秋天", 20),
    WINTER("冬天", 5);

    private final String chineseName;
    private final int averageTemp;

    Season(String chineseName, int averageTemp) {
        this.chineseName = chineseName;
        this.averageTemp = averageTemp;
    }

    public String getChineseName() {
        return chineseName;
    }

    public int getAverageTemp() {
        return averageTemp;
    }
} 