import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.Optional;
import java.io.UnsupportedEncodingException;
import java.time.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
/**
 * Java8Tester
 */
public class Java8Tester {
    public static void main(String args[]){
       System.out.println("使用 Java 7: ");
         
       // 计算空字符串
       List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
       System.out.println("列表: " +strings);
       long count = getCountEmptyStringUsingJava7(strings);
         
       System.out.println("空字符数量为: " + count);
       count = getCountLength3UsingJava7(strings);
         
       System.out.println("字符串长度为 3 的数量为: " + count);
         
       // 删除空字符串
       List<String> filtered = deleteEmptyStringsUsingJava7(strings);
       System.out.println("筛选后的列表: " + filtered);
         
       // 删除空字符串，并使用逗号把它们合并起来
       String mergedString = getMergedStringUsingJava7(strings,", ");
       System.out.println("合并字符串: " + mergedString);
       List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
         
       // 获取列表元素平方数
       List<Integer> squaresList = getSquares(numbers);
       System.out.println("平方数列表: " + squaresList);
       List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
         
       System.out.println("列表: " +integers);
       System.out.println("列表中最大的数 : " + getMax(integers));
       System.out.println("列表中最小的数 : " + getMin(integers));
       System.out.println("所有数之和 : " + getSum(integers));
       System.out.println("平均数 : " + getAverage(integers));
       System.out.println("随机数: ");
         
       // 输出10个随机数
       Random random = new Random();
         
       for(int i=0; i < 10; i++){
          System.out.println(random.nextInt());
       }
         
       System.out.println("使用 Java 8: ");
       System.out.println("列表: " +strings);
         
       count = strings.stream().filter(string->string.isEmpty()).count();
       System.out.println("空字符串数量为: " + count);
         
       count = strings.stream().filter(string -> string.length() == 3).count();
       System.out.println("字符串长度为 3 的数量为: " + count);
         
       filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());
       System.out.println("筛选后的列表: " + filtered);
         
       mergedString = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.joining(", "));
       System.out.println("合并字符串: " + mergedString);
         
       squaresList = numbers.stream().map( i ->i*i).distinct().collect(Collectors.toList());
       System.out.println("Squares List: " + squaresList);
       System.out.println("列表: " +integers);
         
       IntSummaryStatistics stats = integers.stream().mapToInt((x) ->x).summaryStatistics();
         
       System.out.println("列表中最大的数 : " + stats.getMax());
       System.out.println("列表中最小的数 : " + stats.getMin());
       System.out.println("所有数之和 : " + stats.getSum());
       System.out.println("平均数 : " + stats.getAverage());
       System.out.println("随机数: ");
         
       random.ints().limit(10).sorted().forEach(System.out::println);
         
       // 并行处理
       count = strings.parallelStream().filter(string -> string.isEmpty()).count();
       System.out.println("空字符串的数量为: " + count);
    }
   
    public Integer sum(Optional<Integer> a, Optional<Integer> b){
    
        // Optional.isPresent - 判断值是否存在
          
        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());
          
        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));
          
        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
     }

    private static int getCountEmptyStringUsingJava7(List<String> strings){
       int count = 0;
         
       for(String string: strings){
         
          if(string.isEmpty()){
             count++;
          }
       }
       return count;
    }
     
    private static int getCountLength3UsingJava7(List<String> strings){
       int count = 0;
         
       for(String string: strings){
         
          if(string.length() == 3){
             count++;
          }
       }
       return count;
    }
     
    private static List<String> deleteEmptyStringsUsingJava7(List<String> strings){
       List<String> filteredList = new ArrayList<String>();
         
       for(String string: strings){
         
          if(!string.isEmpty()){
              filteredList.add(string);
          }
       }
       return filteredList;
    }
     
    private static String getMergedStringUsingJava7(List<String> strings, String separator){
       StringBuilder stringBuilder = new StringBuilder();
         
       for(String string: strings){
         
          if(!string.isEmpty()){
             stringBuilder.append(string);
             stringBuilder.append(separator);
          }
       }
       String mergedString = stringBuilder.toString();
       return mergedString.substring(0, mergedString.length()-2);
    }
     
    private static List<Integer> getSquares(List<Integer> numbers){
       List<Integer> squaresList = new ArrayList<Integer>();
         
       for(Integer number: numbers){
          Integer square = new Integer(number.intValue() * number.intValue());
             
          if(!squaresList.contains(square)){
             squaresList.add(square);
          }
       }
       return squaresList;
    }
     
    private static int getMax(List<Integer> numbers){
       int max = numbers.get(0);
         
       for(int i=1;i < numbers.size();i++){
         
          Integer number = numbers.get(i);
             
          if(number.intValue() > max){
             max = number.intValue();
          }
       }
       return max;
    }
     
    private static int getMin(List<Integer> numbers){
       int min = numbers.get(0);
         
       for(int i=1;i < numbers.size();i++){
          Integer number = numbers.get(i);
         
          if(number.intValue() < min){
             min = number.intValue();
          }
       }
       return min;
    }
     
    private static int getSum(List numbers){
       int sum = (int)(numbers.get(0));
         
       for(int i=1;i < numbers.size();i++){
          sum += (int)numbers.get(i);
       }
       return sum;
    }
     
    private static int getAverage(List<Integer> numbers){
       return getSum(numbers) / numbers.size();
    }

    public void testLocalDateTime(){
    
        // 获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);
          
        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);
          
        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();
          
        System.out.println("月: " + month +", 日: " + day +", 秒: " + seconds);
          
        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);
          
        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);
          
        // 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);
          
        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
     }

     public void scriptDemo(){
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
          
        String name = "Runoob";
        Integer result = null;
        
        try {
           nashorn.eval("print('" + name + "')");
           result = (Integer) nashorn.eval("10 + 2");
           
        }catch(ScriptException e){
           System.out.println("执行脚本错误: "+ e.getMessage());
        }
        
        System.out.println(result.toString());
     }

     public void base64Demo(){
        try {

            // 使用基本编码
            String base64encodedString = Base64.getEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
            System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);
           
            // 解码
            byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
           
            System.out.println("原始字符串: " + new String(base64decodedBytes, "utf-8"));
            base64encodedString = Base64.getUrlEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
            System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);
           
            StringBuilder stringBuilder = new StringBuilder();
           
            for (int i = 0; i < 10; ++i) {
               stringBuilder.append(UUID.randomUUID().toString());
            }
           
            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
            String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);
            
         }catch(UnsupportedEncodingException e){
            System.out.println("Error :" + e.getMessage());
         }
     }

 }
