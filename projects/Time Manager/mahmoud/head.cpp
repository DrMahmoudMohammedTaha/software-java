#include "stdafx.h"
#include "head.h"

string profile::getname ()
{return name ;}
void profile::adda()
{
	cout<<"Please enter your mission\n=after finishing\n";
	getline(cin,action[num],'\=');
	action[num]=action[num].erase(0,1);
	num++;
}
void profile::display()
{
	for(int i=0;i<num;i++)
cout<<i+1<<"- "<<action[i]<<endl;
}

	void	profile::arrange(string x)
	{int j;
	string cha="no";
	f:
		for (int i=0;i<num;i++)
			if (action[i]==x)
			{ j=i;
		cha="yes";}
			
		if (cha=="no")
		{cout<<"No mission with this name.";
		getline(cin,x,'=');
		
	x=x.erase(0,1);
		goto f;
		}

		else
		{
			for(j;j<num;j++)
				action[j]=action[j+1];
			action [j]='/0';
			num--;
		}
	}
	