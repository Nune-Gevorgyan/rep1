import java.util.Arrays;

public class Spring {

        Spring(){

        };
        private double k = 1;

        Spring(double k){
            this.k = k;
        }

        private void setK(double k) {
            this.k = k;
        }
        public double getK(){
            return k;
        }

        public double[] move(double t, double dt, double x0, double v0) {
            double init_t = 0;
            double mass = 1;
            double tmp = (k/mass);
            double omega = Math.sqrt(tmp);
            int tmp1 = (int)(t/dt);
            double[] arr = new double[tmp1];

            for(int i =0; i<arr.length;i++){
                arr[i] = x0*Math.cos(init_t*omega) + Math.sin(init_t*omega)*(v0/omega);
                init_t+=dt;
            }
            return arr;
        }

        public double[] move(double t, double dt, double x0) {
            double init_t = 0;
            double init_v = 0;
            double mass = 1;
            double tmp = (k/mass);
            int tmp1 = (int)(t/dt);
            double omega = Math.sqrt(tmp);
            double[] arr = new double[tmp1];
            for(int i = 0;i<arr.length; i++){
                arr[i] = x0*Math.cos(init_t*omega) + Math.sin(init_t*omega)*(init_v/omega);
                init_t+=dt;
            }
            return arr;
        }

        public double[] move(double t0, double t1, double dt, double x0, double v0) {
            double init_t = 0;
            double mass = 1;
            double tmp = (k/mass);
            double omega = Math.sqrt(tmp);
            int tmp1 = (int)((t1-t0)/dt);
            double[] arr = new double[tmp1];

            for(int i = 0;i<arr.length; i++){
                arr[i] = x0*Math.cos(init_t*omega) + Math.sin(init_t*omega)*(v0/omega);
                init_t+=dt;
            }
            return arr;
        }

        public double[] move(double t0, double t1, double dt, double x0, double v0, double m) {
            double init_t = 0;
            double mass = 1;
            double tmp = (k/mass);
            double omega = Math.sqrt(tmp);
            int tmp1 = (int)((t1-t0)/dt);
            double[] arr = new double[tmp1];

            for(int i = 0;i<arr.length; i++){
                arr[i] = x0*Math.cos(init_t*omega) + Math.sin(init_t*omega)*(v0/omega);
                init_t+=dt;
            }
            return arr;
        }

    public Spring inSeries(Spring that) {
            double tmp = this.k*that.k;
            double tmp1 = this.k + this.k;

            return new Spring(tmp/tmp1);
    }

    public Spring inParallel(Spring that) {
        double tmp = this.k +that.k;

        return new Spring(tmp);
    }


}

class SpringMain{
    public static void main(String[] args) {
        Spring spring = new Spring(2);
        String str = Arrays.toString(spring.move(1.1,4.4,1.001,3));
        System.out.println(str);
    }
}
