package code;

public class SwitchExpressionExample {
    public static void main(String[] args) {
        // 1. 传统switch语句
        System.out.println("=== 传统switch语句 ===");
        int dayOfWeek = 3;
        String traditional;
        
        switch (dayOfWeek) {
            case 1:
                traditional = "星期一";
                break;
            case 2:
                traditional = "星期二";
                break;
            case 3:
                traditional = "星期三";
                break;
            case 4:
                traditional = "星期四";
                break;
            case 5:
                traditional = "星期五";
                break;
            case 6:
            case 7:
                traditional = "周末";
                break;
            default:
                traditional = "无效日期";
        }
        System.out.println("传统方式结果：" + traditional);

        // 2. 新式switch表达式 - 使用箭头语法
        System.out.println("\n=== 新式switch表达式（箭头语法）===");
        String modern = switch (dayOfWeek) {
            case 1 -> "星期一";
            case 2 -> "星期二";
            case 3 -> "星期三";
            case 4 -> "星期四";
            case 5 -> "星期五";
            case 6, 7 -> "周末";
            default -> "无效日期";
        };
        System.out.println("现代方式结果：" + modern);

        // 3. switch表达式与yield关键字
        System.out.println("\n=== 使用yield的switch表达式 ===");
        String withYield = switch (dayOfWeek) {
            case 1, 2, 3, 4, 5 -> {
                String period = "工作日";
                yield period + "：" + dayOfWeek;
            }
            case 6, 7 -> {
                String period = "周末";
                yield period + "：放松时间";
            }
            default -> {
                yield "无效日期";
            }
        };
        System.out.println("使用yield的结果：" + withYield);

        // 4. switch表达式用于枚举
        System.out.println("\n=== 枚举类型的switch表达式 ===");
        Season season = Season.SPRING;
        String activity = switch (season) {
            case SPRING -> "春游";
            case SUMMER -> "游泳";
            case AUTUMN -> "赏秋";
            case WINTER -> "滑雪";
        };
        System.out.println("季节活动：" + activity);

        // 5. 多值匹配示例
        System.out.println("\n=== 多值匹配示例 ===");
        int score = 85;
        String grade = switch (score / 10) {
            case 9, 10 -> "优秀";
            case 8 -> "良好";
            case 7 -> "中等";
            case 6 -> "及格";
            case 0, 1, 2, 3, 4, 5 -> "不及格";
            default -> "无效分数";
        };
        System.out.println("成绩等级：" + grade);

        // 6. 复杂逻辑示例
        System.out.println("\n=== 复杂逻辑示例 ===");
        String role = "ADMIN";
        String permission = switch (role) {
            case "ADMIN" -> {
                System.out.println("检查管理员权限...");
                yield "完全访问权限";
            }
            case "USER" -> {
                System.out.println("检查用户权限...");
                yield "有限访问权限";
            }
            case "GUEST" -> {
                System.out.println("检查访客权限...");
                yield "只读权限";
            }
            default -> "无权限";
        };
        System.out.println("权限级别：" + permission);
    }

    // 用于示例的枚举类型
    enum Season {
        SPRING, SUMMER, AUTUMN, WINTER
    }
} 