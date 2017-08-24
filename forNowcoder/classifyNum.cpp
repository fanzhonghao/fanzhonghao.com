#include <iostream>
#include <stdio.h>
using  namespace std;
int main(int argc, char const *argv[]) {
  int num,a[1000],i,cun[5] = {0,0,0,0,0};
  cin >> num;
  for (i = 0;i < num;i++){
    cin >> a[i];
  }
  int biaoji = 0;
  int sum = 0,sum1 = 0,no = 0,sum2 = 0,max = 0,count = 0;
  for (i = 0;i < num;i++) {
    if (a[i] % 5 == 0 && a[i] % 2 == 0) {
      cun[0] = 1;
      sum += a[i];
    } else if (a[i] % 5 == 1){
      cun[1] = 1;
      if (biaoji == 0) {
        sum1 += a[i];
        biaoji = 1;
      }else {
        sum1 -= a[i];
        biaoji = 0;
      }
      }else if (a[i] % 5 == 2) {
        cun[2] = 1;
        no++;
      }else if (a[i] % 5 == 3) {
        cun[3] = 1;
        count++;
        sum2 += a[i];
      }else {
        cun[4] = 1;
        if(max < a[i]) max = a[i];
      }
  }
  float nu = (double)(sum2)/count;
  if (cun[0] == 0) {
    std::cout << "N " ;
  }else cout << sum << " ";
  if (cun[1] == 0) {
    std::cout << "N " ;
  }else cout << sum1 << " ";
  cout << no << " ";
  if (cun[3] == 0) {
    std::cout << "N ";
  }else printf("%.1f ",nu);
  if (cun[4] ==0) {
    cout << "N" <<endl;
  }else cout << max <<endl;
  return 0;
}
