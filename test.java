public class test {

    private static String byte2Hex(byte[] bytes){
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i=0;i<bytes.length;i++){
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length()==1){
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    public static byte[] str2byte(String datas){
        return datas.getBytes();
    }

    public static String byte2str(byte[] datas){
        return new String(datas);
    }


    public static void anlyis(String datas){

            byte[] bytes = str2byte(datas);

            byte buff = bytes[5];
            int userNo = buff >>> 7;
            int dataNo = buff & 0x7F;
            int value = 0;
            int offset = 6;
            value = (int) (((bytes[offset] & 0xFF)<<24)
                    | ((bytes[offset+1] & 0xFF)<<16)
                    | ((bytes[offset+2] & 0xFF)<<8)
                    | ((bytes[offset+3] & 0xFF)));
            int measure_level = (value >>> 28);
            int arrhythmia = bytes[6] & 0x08;
            int measure_minute = value & 0x03F;
            int measure_hour = (value>>>6) & 0x01F;
            int measure_day = (value>>>11) & 0x03F;
            int measure_month = (value>>>17) & 0x0F;
            int check_year = (value>>>21) & 0x03F;
            String measure_year = String.format("20%02d",check_year);
            int systolic_pressure = (bytes[10]&0x0FF) + 30;
            int diastolic_pressure = bytes[11]&0x0FF;
            int heart_rate = bytes[12]&0x0FF;

           System.out.println("userNo:"+userNo+"");
           System.out.println("dataNo:"+dataNo+"");
           System.out.println("measure_level:"+measure_level+"");
           System.out.println("arrhythmia:"+arrhythmia+"");
           System.out.println("measure_year:"+ measure_year);
           System.out.println("measure_month:"+measure_month+"");
           System.out.println("measure_day:"+measure_day+"");
           System.out.println("measure_hour:"+measure_hour+"");
           System.out.println("measure_minute:"+ measure_minute+"");
           System.out.println("systolic_pressure:"+systolic_pressure+"");
           System.out.println("diastolic_pressure:"+diastolic_pressure+"");
           System.out.println("heart_rate:"+heart_rate+"");
             
    }

    public static void main(String[] arg){
        String datas = "0x02129093e7342342";
        byte[] bytes = str2byte(datas);
        for(byte e:bytes){
            System.out.println(e);
        }
        System.out.println(byte2str(bytes));
        System.out.println(byte2Hex(bytes));
        anlyis(datas);
    }

    
}