#include <fstream>
#include <iostream>
#include <string>
#include <time.h>
#include <ctime>
using namespace std;
class profile 
{protected:
	
public:
	string action[20];
	string name;
    int num;
	string getname();
	
	~profile ()
	{}
	profile ():name(" "),num(0)
	{}
	profile (string x):name (x),num(0)
	{}
	void display();
	void adda( );
	void	arrange(string );
};
