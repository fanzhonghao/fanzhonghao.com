#include <iostream>
using namespace std;
int main(int argc, char const *argv[]) {
  int t;
  double a[10],b[10],c[10];
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> a[i] >> b[i] >> c[i];
  }
  for (int i = 0;i < t;i++)
  {
    if (a[i] + b[i] > c[i]) {
      cout << "Case #" << i+1 << ":" << " true" << "\n";
    }else{
      cout << "Case #" << i+1 << ":" << " false" << "\n";
    }
  }
  return 0;
}
