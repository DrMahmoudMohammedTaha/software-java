#include "head.h"
#include <msclr\marshal_cppstd.h>

int p;
fstream myReadFile;
string fd;
int rob3,remaind;
string line;
profile *pptr[20];
profile *ptr=new profile();
int d,u;
bool selected = true;
using namespace msclr::interop;

#pragma once



namespace mahmoud {
	
	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;
	/// <summary>
	/// Summary for Form1
	/// </summary>

	public ref class Form1 : public System::Windows::Forms::Form
	{
	public:
		Form1(void)
		{
			InitializeComponent();
			//
			//TODO: Add the constructor code here
			//
		}

	protected:
		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		~Form1()
		{
			if (components)
			{
				delete components;
			}
		}

	protected: 


	private: System::Windows::Forms::Button^  button4;
	private: System::Windows::Forms::Button^  button5;
	private: System::Windows::Forms::Label^  l1;
	private: System::Windows::Forms::Label^  l2;
	private: System::Windows::Forms::Label^  l3;




















	private: System::Windows::Forms::ListBox^  mylist;









	private: System::Windows::Forms::TextBox^  text;


	private: System::Windows::Forms::Button^  addbt;





	private: System::Windows::Forms::ListBox^  list;
	private: System::Windows::Forms::Button^  button6;
	private: System::Windows::Forms::Button^  button1;

	private: System::Windows::Forms::Button^  button3;
























	protected: 

	private:
		/// <summary>
		/// Required designer variable.
		/// </summary>
		System::ComponentModel::Container ^components;

#pragma region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		void InitializeComponent(void)
		{
			System::ComponentModel::ComponentResourceManager^  resources = (gcnew System::ComponentModel::ComponentResourceManager(Form1::typeid));
			this->button4 = (gcnew System::Windows::Forms::Button());
			this->button5 = (gcnew System::Windows::Forms::Button());
			this->l1 = (gcnew System::Windows::Forms::Label());
			this->l2 = (gcnew System::Windows::Forms::Label());
			this->l3 = (gcnew System::Windows::Forms::Label());
			this->mylist = (gcnew System::Windows::Forms::ListBox());
			this->addbt = (gcnew System::Windows::Forms::Button());
			this->text = (gcnew System::Windows::Forms::TextBox());
			this->list = (gcnew System::Windows::Forms::ListBox());
			this->button6 = (gcnew System::Windows::Forms::Button());
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->button3 = (gcnew System::Windows::Forms::Button());
			this->SuspendLayout();
			// 
			// button4
			// 
			this->button4->BackColor = System::Drawing::SystemColors::ControlLightLight;
			this->button4->Font = (gcnew System::Drawing::Font(L"Viner Hand ITC", 12, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->button4->Location = System::Drawing::Point(128, 209);
			this->button4->Name = L"button4";
			this->button4->Size = System::Drawing::Size(110, 49);
			this->button4->TabIndex = 3;
			this->button4->Text = L"Save";
			this->button4->UseVisualStyleBackColor = false;
			this->button4->Click += gcnew System::EventHandler(this, &Form1::button4_Click);
			// 
			// button5
			// 
			this->button5->BackColor = System::Drawing::SystemColors::ControlLightLight;
			this->button5->Font = (gcnew System::Drawing::Font(L"Viner Hand ITC", 12, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->button5->Location = System::Drawing::Point(12, 264);
			this->button5->Name = L"button5";
			this->button5->Size = System::Drawing::Size(110, 49);
			this->button5->TabIndex = 4;
			this->button5->Text = L"Exit";
			this->button5->UseVisualStyleBackColor = false;
			this->button5->Click += gcnew System::EventHandler(this, &Form1::button5_Click);
			// 
			// l1
			// 
			this->l1->BackColor = System::Drawing::Color::Transparent;
			this->l1->BorderStyle = System::Windows::Forms::BorderStyle::Fixed3D;
			this->l1->Font = (gcnew System::Drawing::Font(L"Cooper Black", 15.75F, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->l1->ForeColor = System::Drawing::Color::White;
			this->l1->Location = System::Drawing::Point(14, 17);
			this->l1->Name = L"l1";
			this->l1->Size = System::Drawing::Size(175, 40);
			this->l1->TabIndex = 5;
			// 
			// l2
			// 
			this->l2->BackColor = System::Drawing::Color::Transparent;
			this->l2->BorderStyle = System::Windows::Forms::BorderStyle::Fixed3D;
			this->l2->Font = (gcnew System::Drawing::Font(L"Cooper Black", 15.75F, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->l2->ForeColor = System::Drawing::Color::White;
			this->l2->Location = System::Drawing::Point(14, 88);
			this->l2->Name = L"l2";
			this->l2->Size = System::Drawing::Size(175, 40);
			this->l2->TabIndex = 6;
			// 
			// l3
			// 
			this->l3->BackColor = System::Drawing::Color::Transparent;
			this->l3->BorderStyle = System::Windows::Forms::BorderStyle::Fixed3D;
			this->l3->Font = (gcnew System::Drawing::Font(L"Cooper Black", 15.75F, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->l3->ForeColor = System::Drawing::Color::White;
			this->l3->Location = System::Drawing::Point(14, 159);
			this->l3->Name = L"l3";
			this->l3->Size = System::Drawing::Size(175, 40);
			this->l3->TabIndex = 7;
			// 
			// mylist
			// 
			this->mylist->BackColor = System::Drawing::Color::SteelBlue;
			this->mylist->Font = (gcnew System::Drawing::Font(L"Traditional Arabic", 12, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->mylist->ForeColor = System::Drawing::Color::White;
			this->mylist->FormattingEnabled = true;
			this->mylist->ItemHeight = 24;
			this->mylist->Location = System::Drawing::Point(378, 17);
			this->mylist->Name = L"mylist";
			this->mylist->Size = System::Drawing::Size(321, 292);
			this->mylist->TabIndex = 18;
			this->mylist->Click += gcnew System::EventHandler(this, &Form1::mylist_Click);
			this->mylist->SelectedIndexChanged += gcnew System::EventHandler(this, &Form1::mylist_SelectedIndexChanged);
			this->mylist->DragDrop += gcnew System::Windows::Forms::DragEventHandler(this, &Form1::mylist_DragDrop);
			this->mylist->DoubleClick += gcnew System::EventHandler(this, &Form1::mylist_DoubleClick);
			this->mylist->Enter += gcnew System::EventHandler(this, &Form1::mylist_Enter);
			this->mylist->KeyPress += gcnew System::Windows::Forms::KeyPressEventHandler(this, &Form1::mylist_KeyPress);
			// 
			// addbt
			// 
			this->addbt->BackColor = System::Drawing::SystemColors::ControlLightLight;
			this->addbt->Location = System::Drawing::Point(630, 336);
			this->addbt->Name = L"addbt";
			this->addbt->Size = System::Drawing::Size(70, 32);
			this->addbt->TabIndex = 22;
			this->addbt->Text = L"Done";
			this->addbt->UseVisualStyleBackColor = false;
			this->addbt->Visible = false;
			this->addbt->Click += gcnew System::EventHandler(this, &Form1::addbt_Click);
			// 
			// text
			// 
			this->text->Font = (gcnew System::Drawing::Font(L"Tahoma", 9.75F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->text->Location = System::Drawing::Point(16, 319);
			this->text->Multiline = true;
			this->text->Name = L"text";
			this->text->Size = System::Drawing::Size(608, 55);
			this->text->TabIndex = 24;
			this->text->TextChanged += gcnew System::EventHandler(this, &Form1::text_TextChanged_1);
			// 
			// list
			// 
			this->list->Font = (gcnew System::Drawing::Font(L"Tahoma", 9.75F, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->list->FormattingEnabled = true;
			this->list->ItemHeight = 16;
			this->list->Location = System::Drawing::Point(196, 17);
			this->list->Name = L"list";
			this->list->Size = System::Drawing::Size(174, 180);
			this->list->TabIndex = 28;
			this->list->Visible = false;
			this->list->Click += gcnew System::EventHandler(this, &Form1::list_Click);
			this->list->SelectedIndexChanged += gcnew System::EventHandler(this, &Form1::list_SelectedIndexChanged);
			this->list->SelectedValueChanged += gcnew System::EventHandler(this, &Form1::list_SelectedValueChanged_1);
			this->list->DoubleClick += gcnew System::EventHandler(this, &Form1::list_DoubleClick);
			this->list->Enter += gcnew System::EventHandler(this, &Form1::list_Enter);
			this->list->KeyPress += gcnew System::Windows::Forms::KeyPressEventHandler(this, &Form1::list_KeyPress);
			this->list->MouseDown += gcnew System::Windows::Forms::MouseEventHandler(this, &Form1::list_MouseDown);
			this->list->MouseEnter += gcnew System::EventHandler(this, &Form1::list_MouseEnter);
			this->list->MouseHover += gcnew System::EventHandler(this, &Form1::list_MouseHover);
			// 
			// button6
			// 
			this->button6->BackColor = System::Drawing::SystemColors::ControlLightLight;
			this->button6->Font = (gcnew System::Drawing::Font(L"Viner Hand ITC", 12, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->button6->Location = System::Drawing::Point(12, 209);
			this->button6->Name = L"button6";
			this->button6->Size = System::Drawing::Size(110, 49);
			this->button6->TabIndex = 29;
			this->button6->Text = L"Delete All";
			this->button6->UseVisualStyleBackColor = false;
			this->button6->Click += gcnew System::EventHandler(this, &Form1::button6_Click_1);
			// 
			// button1
			// 
			this->button1->BackColor = System::Drawing::SystemColors::ControlLightLight;
			this->button1->Font = (gcnew System::Drawing::Font(L"Viner Hand ITC", 12, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->button1->Location = System::Drawing::Point(128, 264);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(110, 49);
			this->button1->TabIndex = 30;
			this->button1->Text = L"get out";
			this->button1->UseVisualStyleBackColor = false;
			this->button1->Click += gcnew System::EventHandler(this, &Form1::button1_Click_3);
			// 
			// button3
			// 
			this->button3->BackColor = System::Drawing::SystemColors::ControlLightLight;
			this->button3->Font = (gcnew System::Drawing::Font(L"Viner Hand ITC", 12, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->button3->Location = System::Drawing::Point(244, 237);
			this->button3->Name = L"button3";
			this->button3->Size = System::Drawing::Size(110, 49);
			this->button3->TabIndex = 31;
			this->button3->Text = L"Edit";
			this->button3->UseVisualStyleBackColor = false;
			this->button3->Click += gcnew System::EventHandler(this, &Form1::button3_Click_1);
			// 
			// Form1
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(7, 16);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->BackgroundImage = (cli::safe_cast<System::Drawing::Image^  >(resources->GetObject(L"$this.BackgroundImage")));
			this->BackgroundImageLayout = System::Windows::Forms::ImageLayout::Stretch;
			this->ClientSize = System::Drawing::Size(714, 380);
			this->Controls->Add(this->button3);
			this->Controls->Add(this->button1);
			this->Controls->Add(this->button6);
			this->Controls->Add(this->list);
			this->Controls->Add(this->text);
			this->Controls->Add(this->addbt);
			this->Controls->Add(this->mylist);
			this->Controls->Add(this->l3);
			this->Controls->Add(this->l2);
			this->Controls->Add(this->l1);
			this->Controls->Add(this->button5);
			this->Controls->Add(this->button4);
			this->Font = (gcnew System::Drawing::Font(L"Tahoma", 10));
			this->Name = L"Form1";
			this->Text = L"Peace be upon you, Time Manager";
			this->Load += gcnew System::EventHandler(this, &Form1::Form1_Load);
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
		void initial()
{
	selected=false;
mylist->Items->Clear();
addbt->Visible=false;
list->Items->Clear();
text->Clear();
//code to intialize the list
if(p==0)
			 {MessageBox::Show("Sorry,No data to be displayed.");
			 return ;}
				list->Visible=true;
			 list->Items->Clear();
			mylist->Items->Clear();
			 for(int k=0;k<p;k++)
		 list->Items->Add(gcnew String((">> "+pptr[k]->name).c_str()));
		}


		
	private: System::Void button1_MouseHover(System::Object^  sender, System::EventArgs^  e) {
			 }
	
	private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e) {
			 }
		private: System::Void button1_Click_1(System::Object^  sender, System::EventArgs^  e) {

			 }
	private: System::Void button1_MouseEnter(System::Object^  sender, System::EventArgs^  e) {
			 }
private: System::Void button2_Click(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void button1_Click_2(System::Object^  sender, System::EventArgs^  e) {
		 }
		 
private: System::Void Form1_Load(System::Object^  sender, System::EventArgs^  e) {

			 //new code
 	time_t rawtime;
struct tm * timeinfo;
char buffer [80];
string waw;
time (&rawtime);
timeinfo = localtime (&rawtime);
strftime (buffer,80,"%I:%M:%S%p.",timeinfo);
for (int i=0;i<10;i++)
	waw+=buffer[i];
 l1->Text=gcnew String(waw.c_str());
 //end of new code*/
		//date code
		time_t t = time(0);   // get time now
    struct tm * now = localtime( & t );
    int year=now->tm_year + 1900; 
       int month=now->tm_mon + 1;
         int day =now->tm_mday;
		char bffr[100] = {0};
		int number_base = 10;
		string output = itoa(year, bffr, number_base);
		 l2->Text=gcnew String(output.c_str());
		 output = itoa(month, bffr, number_base);
		 l2->Text+=" / ";
		 l2->Text+=gcnew String(output.c_str());
		 l2->Text+=" / ";
		output = itoa(day, bffr, number_base);
		 l2->Text+=gcnew String(output.c_str());
		 //end of date code
		 

		 ifstream myReadFile;
		 
		 myReadFile.open("date.txt", ios::app | ios::out |ios::in | ios::binary);
		myReadFile>>d;
		myReadFile.close();
		myReadFile.open("day.txt", ios::app | ios::out |ios::in | ios::binary);
	myReadFile>>u;
	myReadFile.close();
		
	myReadFile.open("dayname.txt", ios::app | ios::out |ios::in | ios::binary);
	myReadFile>>line;
	myReadFile.close();
	myReadFile.open("rb3.txt", ios::app | ios::out |ios::in | ios::binary);
	myReadFile>>rob3;
	myReadFile.close();
myReadFile.open("remain.txt", ios::app | ios::out |ios::in | ios::binary);
	myReadFile>>remaind;
	myReadFile.close();

	myReadFile.open("numobj.txt", ios::app | ios::out |ios::in | ios::binary);
	myReadFile>>p;
	myReadFile.close();
	for (int u=0;u<20;u++)
	pptr [u]=new profile();
	
		//new code
	myReadFile.open("f1.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[0]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[0]->num=(int)fd[0]-'0';
	if (pptr[0]->num!=0)
	{getline(myReadFile,pptr[0]->name);
	for(int i=0;i<	pptr[0]->num;i++)
	getline(myReadFile,pptr[0]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f2.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[1]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[1]->num=(int)fd[0]-'0';
	if (pptr[1]->num!=0)
	{getline(myReadFile,pptr[1]->name);
	for(int i=0;i<	pptr[1]->num;i++)
	getline(myReadFile,pptr[1]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f3.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[2]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[2]->num=(int)fd[0]-'0';
	if (pptr[2]->num!=0)
	{getline(myReadFile,pptr[2]->name);
	for(int i=0;i<	pptr[2]->num;i++)
	getline(myReadFile,pptr[2]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f4.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[3]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[3]->num=(int)fd[0]-'0';
	if (pptr[3]->num!=0)
	{getline(myReadFile,pptr[3]->name);
	for(int i=0;i<	pptr[3]->num;i++)
	getline(myReadFile,pptr[3]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f5.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[4]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[4]->num=(int)fd[0]-'0';
	if (pptr[4]->num!=0)
	{getline(myReadFile,pptr[4]->name);
	for(int i=0;i<	pptr[4]->num;i++)
	getline(myReadFile,pptr[4]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f6.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[5]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[5]->num=(int)fd[0]-'0';
	if (pptr[5]->num!=0)
	{getline(myReadFile,pptr[5]->name);
	for(int i=0;i<	pptr[5]->num;i++)
	getline(myReadFile,pptr[5]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f7.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[6]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[6]->num=(int)fd[0]-'0';
	if (pptr[6]->num!=0)
	{getline(myReadFile,pptr[6]->name);
	for(int i=0;i<	pptr[6]->num;i++)
	getline(myReadFile,pptr[6]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f8.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[7]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[7]->num=(int)fd[0]-'0';
	if (pptr[7]->num!=0)
	{getline(myReadFile,pptr[7]->name);
	for(int i=0;i<	pptr[7]->num;i++)
	getline(myReadFile,pptr[7]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f9.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[8]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[8]->num=(int)fd[0]-'0';
	if (pptr[8]->num!=0)
	{getline(myReadFile,pptr[8]->name);
	for(int i=0;i<	pptr[8]->num;i++)
	getline(myReadFile,pptr[8]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f10.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[9]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[9]->num=(int)fd[0]-'0';
	if (pptr[9]->num!=0)
	{getline(myReadFile,pptr[9]->name);
	for(int i=0;i<	pptr[9]->num;i++)
	getline(myReadFile,pptr[9]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f11.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[10]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[10]->num=(int)fd[0]-'0';
	if (pptr[10]->num!=0)
	{getline(myReadFile,pptr[10]->name);
	for(int i=0;i<	pptr[10]->num;i++)
	getline(myReadFile,pptr[10]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f12.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[11]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[11]->num=(int)fd[0]-'0';
	if (pptr[11]->num!=0)
	{getline(myReadFile,pptr[11]->name);
	for(int i=0;i<	pptr[11]->num;i++)
	getline(myReadFile,pptr[11]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f13.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[12]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[12]->num=(int)fd[0]-'0';
	if (pptr[12]->num!=0)
	{getline(myReadFile,pptr[12]->name);
	for(int i=0;i<	pptr[12]->num;i++)
	getline(myReadFile,pptr[12]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f14.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[13]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[13]->num=(int)fd[0]-'0';
	if (pptr[13]->num!=0)
	{getline(myReadFile,pptr[13]->name);
	for(int i=0;i<	pptr[13]->num;i++)
	getline(myReadFile,pptr[13]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f15.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[14]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[14]->num=(int)fd[0]-'0';
	if (pptr[14]->num!=0)
	{getline(myReadFile,pptr[14]->name);
	for(int i=0;i<	pptr[14]->num;i++)
	getline(myReadFile,pptr[14]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f16.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[15]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[15]->num=(int)fd[0]-'0';
	if (pptr[15]->num!=0)
	{getline(myReadFile,pptr[15]->name);
	for(int i=0;i<	pptr[15]->num;i++)
	getline(myReadFile,pptr[15]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f17.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[16]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[16]->num=(int)fd[0]-'0';
	if (pptr[16]->num!=0)
	{getline(myReadFile,pptr[16]->name);
	for(int i=0;i<	pptr[16]->num;i++)
		getline(myReadFile,pptr[16]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f18.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[17]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[17]->num=(int)fd[0]-'0';
	if (pptr[17]->num!=0)
	{getline(myReadFile,pptr[17]->name);
	for(int i=0;i<	pptr[17]->num;i++)
	getline(myReadFile,pptr[17]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f19.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[18]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[18]->num=(int)fd[0]-'0';
	if (pptr[18]->num!=0)
	{getline(myReadFile,pptr[18]->name);
	for(int i=0;i<	pptr[18]->num;i++)
	getline(myReadFile,pptr[18]->action[i]);
	}
	myReadFile.close();
myReadFile.open("f20.txt", ios::in);
	getline(myReadFile,fd);
	if (fd.length()>1 &&fd[1]>='0'&&fd[1]<='9')		
	pptr[19]->num=((int)fd[1]-'0')+((int)fd[0]-'0')*10;
	else pptr[19]->num=(int)fd[0]-'0';
	if (pptr[19]->num!=0)
	{getline(myReadFile,pptr[19]->name);
	for(int i=0;i<	pptr[19]->num;i++)
	getline(myReadFile,pptr[19]->action[i]);
	}
	myReadFile.close();
	//end of loading code
		 //code to display name of day
	//new code of week block
	int j =-1 ;
	for(int i = 0 ; i <p ; i++)
	{
		if(pptr[i]->name == "week")
		{
			j = i ;
			break;
		}
	}
	string  week [7];
	if(j != -1 )
	{
		for (int i = 0 ; i < 7 ; i++)
		{
			if(pptr[j]->action[i][0]=='f')
			week[6]=pptr[j]->action[i];
			else if(pptr[j]->action[i][0]=='s' && pptr[j]->action[i][1]=='a')
			week[0]=pptr[j]->action[i];
			else if(pptr[j]->action[i][0]=='s' && pptr[j]->action[i][1]=='u')
			week[1]=pptr[j]->action[i];
			else if(pptr[j]->action[i][0]=='m')
			week[2]=pptr[j]->action[i];
			else if(pptr[j]->action[i][0]=='t' && pptr[j]->action[i][1]=='u')
			week[3]=pptr[j]->action[i];
			else if(pptr[j]->action[i][0]=='w')
			week[4]=pptr[j]->action[i];
			else if(pptr[j]->action[i][0]=='t' && pptr[j]->action[i][1]=='h')
			week[5]=pptr[j]->action[i];

		}

	
	}
	//end of week block
	time_t tt=time(0);
	struct tm *n=localtime(&tt);
	if (n->tm_yday>d)
	{u+=n->tm_yday-d;
	d=n->tm_yday;}
	while(u>7)
	u-=7;
	if (u==1)
	l3->Text="Saturday";
	if (u==2)
	l3->Text="Sunday";
	if (u==3)
	l3->Text="Monday";
	if (u==4)
	l3->Text="Tuesday";
	if (u==5)
	l3->Text="Wednesday";
	if (u==6)
	l3->Text="Thursday";
	if (u==7)
	l3->Text="Friday";
	//part of code of week block
	string daywork ;
	
	for ( int i = 0 ; i < week[u-1].size() ; i++ )
	{	if(week[u-1][i] != '+')
		daywork += week[u-1][i];
		else 
		daywork += "\n";
	}
	MessageBox::Show(gcnew String((" "+daywork).c_str()));
		 
		 //end of last code
		//some code for intializing the list
			 if(p==0)
			 {MessageBox::Show("Sorry,No data to be displayed.");
			 return ;}
				list->Visible=true;
			 list->Items->Clear();
			mylist->Items->Clear();
			 for(int k=0;k<p;k++)
		 list->Items->Add(gcnew String((">> "+pptr[k]->name).c_str()));
		 
}
private: System::Void button5_Click(System::Object^  sender, System::EventArgs^  e) {
			{myReadFile.open("f1.txt", ios::trunc | ios::out |ios::in | ios::binary);
			myReadFile<<0;	
			myReadFile.close();}
	
		{myReadFile.open("f2.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f3.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f4.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f5.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f6.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f7.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f8.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f9.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f10.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f11.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f12.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f13.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f14.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f15.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f16.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f17.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f18.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f19.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f20.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		myReadFile.open("rb3.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<rob3;
		myReadFile.close();
		myReadFile.open("remain.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<remaind;
		myReadFile.close();
		myReadFile.open("dayname.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<line;
		myReadFile.close();

		myReadFile.open("numobj.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<p;
		myReadFile.close();
		myReadFile.open("date.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<d;
		myReadFile.close();
		myReadFile.open("day.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<u;
		myReadFile.close();
	if (p>=1)
	{myReadFile.open("f1.txt", ios::trunc | ios::out |ios::in | ios::binary);
//new code
	myReadFile<<pptr[0]->num<<endl;
	myReadFile<<pptr[0]->name<<endl;
	for(int y=0;y<pptr[0]->num;y++)
		myReadFile<<pptr[0]->action[y]<<endl;
//end of new code
	myReadFile.close();}
	if (p>=2)
		{myReadFile.open("f2.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[1]->num<<endl;
	myReadFile<<pptr[1]->name<<endl;
	for(int y=0;y<pptr[1]->num;y++)
		myReadFile<<pptr[1]->action[y]<<endl;

	myReadFile.close();}
	if (p>=3)
		{myReadFile.open("f3.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[2]->num<<endl;
	myReadFile<<pptr[2]->name<<endl;
	for(int y=0;y<pptr[2]->num;y++)
		myReadFile<<pptr[2]->action[y]<<endl;

	myReadFile.close();}
	if (p>=4)
		{myReadFile.open("f4.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[3]->num<<endl;
	myReadFile<<pptr[3]->name<<endl;
	for(int y=0;y<pptr[3]->num;y++)
		myReadFile<<pptr[3]->action[y]<<endl;

	myReadFile.close();}
	if (p>=5)
		{myReadFile.open("f5.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[4]->num<<endl;
	myReadFile<<pptr[4]->name<<endl;
	for(int y=0;y<pptr[4]->num;y++)
		myReadFile<<pptr[4]->action[y]<<endl;

	myReadFile.close();}
	if (p>=6)
		{myReadFile.open("f6.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[5]->num<<endl;
	myReadFile<<pptr[5]->name<<endl;
	for(int y=0;y<pptr[5]->num;y++)
		myReadFile<<pptr[5]->action[y]<<endl;

	myReadFile.close();}
	if (p>=7)
		{myReadFile.open("f7.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[6]->num<<endl;
	myReadFile<<pptr[6]->name<<endl;
	for(int y=0;y<pptr[6]->num;y++)
		myReadFile<<pptr[6]->action[y]<<endl;

	myReadFile.close();}
	if (p>=8)
		{myReadFile.open("f8.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[7]->num<<endl;
	myReadFile<<pptr[7]->name<<endl;
	for(int y=0;y<pptr[7]->num;y++)
		myReadFile<<pptr[7]->action[y]<<endl;
	myReadFile.close();}
	if (p>=9)
		{myReadFile.open("f9.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[8]->num<<endl;
	myReadFile<<pptr[8]->name<<endl;
	for(int y=0;y<pptr[8]->num;y++)
		myReadFile<<pptr[8]->action[y]<<endl;

	myReadFile.close();}
	if (p>=10)
		{myReadFile.open("f10.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[9]->num<<endl;
	myReadFile<<pptr[9]->name<<endl;
	for(int y=0;y<pptr[9]->num;y++)
		myReadFile<<pptr[9]->action[y]<<endl;

	myReadFile.close();}
	if (p>=11)
		{myReadFile.open("f11.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[10]->num<<endl;
	myReadFile<<pptr[10]->name<<endl;
	for(int y=0;y<pptr[10]->num;y++)
		myReadFile<<pptr[10]->action[y]<<endl;

	myReadFile.close();}
	if (p>=12)
		{myReadFile.open("f12.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[11]->num<<endl;
	myReadFile<<pptr[11]->name<<endl;
	for(int y=0;y<pptr[11]->num;y++)
		myReadFile<<pptr[11]->action[y]<<endl;

	myReadFile.close();}
	if (p>=13)
		{myReadFile.open("f13.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[12]->num<<endl;
	myReadFile<<pptr[12]->name<<endl;
	for(int y=0;y<pptr[12]->num;y++)
		myReadFile<<pptr[12]->action[y]<<endl;

	myReadFile.close();}
	if (p>=14)
		{myReadFile.open("f14.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[13]->num<<endl;
	myReadFile<<pptr[13]->name<<endl;
	for(int y=0;y<pptr[13]->num;y++)
		myReadFile<<pptr[13]->action[y]<<endl;

	myReadFile.close();}
	if (p>=15)
		{myReadFile.open("f15.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[14]->num<<endl;
	myReadFile<<pptr[14]->name<<endl;
	for(int y=0;y<pptr[14]->num;y++)
		myReadFile<<pptr[14]->action[y]<<endl;

	myReadFile.close();}
	if (p>=16)
		{myReadFile.open("f16.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[15]->num<<endl;
	myReadFile<<pptr[15]->name<<endl;
	for(int y=0;y<pptr[15]->num;y++)
		myReadFile<<pptr[15]->action[y]<<endl;

	myReadFile.close();}
	if (p>=17)
		{myReadFile.open("f17.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[16]->num<<endl;
	myReadFile<<pptr[16]->name<<endl;
	for(int y=0;y<pptr[16]->num;y++)
		myReadFile<<pptr[16]->action[y]<<endl;

	myReadFile.close();}
	if (p>=18)
		{myReadFile.open("f18.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[17]->num<<endl;
	myReadFile<<pptr[17]->name<<endl;
	for(int y=0;y<pptr[17]->num;y++)
		myReadFile<<pptr[17]->action[y]<<endl;

	myReadFile.close();}
	if (p>=19)
		{myReadFile.open("f19.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[18]->num<<endl;
	myReadFile<<pptr[18]->name<<endl;
	for(int y=0;y<pptr[18]->num;y++)
		myReadFile<<pptr[18]->action[y]<<endl;

	myReadFile.close();}
	if (p>=20)
		{myReadFile.open("f20.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[19]->num<<endl;
	myReadFile<<pptr[19]->name<<endl;
	for(int y=0;y<pptr[19]->num;y++)
		myReadFile<<pptr[19]->action[y]<<endl;

	myReadFile.close();}


			 Application::Exit();
		 }
private: System::Void button4_Click(System::Object^  sender, System::EventArgs^  e) {
initial();
			 myReadFile.open("f1.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<0;	
myReadFile.close();
	
		myReadFile.open("f2.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f3.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f4.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f5.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f6.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f7.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f8.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f9.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f10.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f11.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f12.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f13.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f14.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f15.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f16.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f17.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f18.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f19.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("f20.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();
	
		myReadFile.open("rb3.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<rob3;
	myReadFile.close();
myReadFile.open("remain.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<remaind;
	myReadFile.close();
myReadFile.open("dayname.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<line;
	myReadFile.close();

		myReadFile.open("numobj.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<p;
	myReadFile.close();
	myReadFile.open("date.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<d;
	myReadFile.close();
	myReadFile.open("day.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<u;
	myReadFile.close();
	if (p>=1)
	{myReadFile.open("f1.txt", ios::trunc | ios::out |ios::in | ios::binary);
//new code
	myReadFile<<pptr[0]->num<<endl;
	myReadFile<<pptr[0]->name<<endl;
	for(int y=0;y<pptr[0]->num;y++)
		myReadFile<<pptr[0]->action[y]<<endl;
//end of new code
	myReadFile.close();}
	if (p>=2)
		{myReadFile.open("f2.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[1]->num<<endl;
	myReadFile<<pptr[1]->name<<endl;
	for(int y=0;y<pptr[1]->num;y++)
		myReadFile<<pptr[1]->action[y]<<endl;

	myReadFile.close();}
	if (p>=3)
		{myReadFile.open("f3.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[2]->num<<endl;
	myReadFile<<pptr[2]->name<<endl;
	for(int y=0;y<pptr[2]->num;y++)
		myReadFile<<pptr[2]->action[y]<<endl;

	myReadFile.close();}
	if (p>=4)
		{myReadFile.open("f4.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[3]->num<<endl;
	myReadFile<<pptr[3]->name<<endl;
	for(int y=0;y<pptr[3]->num;y++)
		myReadFile<<pptr[3]->action[y]<<endl;

	myReadFile.close();}
	if (p>=5)
		{myReadFile.open("f5.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[4]->num<<endl;
	myReadFile<<pptr[4]->name<<endl;
	for(int y=0;y<pptr[4]->num;y++)
		myReadFile<<pptr[4]->action[y]<<endl;

	myReadFile.close();}
	if (p>=6)
		{myReadFile.open("f6.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[5]->num<<endl;
	myReadFile<<pptr[5]->name<<endl;
	for(int y=0;y<pptr[5]->num;y++)
		myReadFile<<pptr[5]->action[y]<<endl;

	myReadFile.close();}
	if (p>=7)
		{myReadFile.open("f7.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[6]->num<<endl;
	myReadFile<<pptr[6]->name<<endl;
	for(int y=0;y<pptr[6]->num;y++)
		myReadFile<<pptr[6]->action[y]<<endl;

	myReadFile.close();}
	if (p>=8)
		{myReadFile.open("f8.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[7]->num<<endl;
	myReadFile<<pptr[7]->name<<endl;
	for(int y=0;y<pptr[7]->num;y++)
		myReadFile<<pptr[7]->action[y]<<endl;
	myReadFile.close();}
	if (p>=9)
		{myReadFile.open("f9.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[8]->num<<endl;
	myReadFile<<pptr[8]->name<<endl;
	for(int y=0;y<pptr[8]->num;y++)
		myReadFile<<pptr[8]->action[y]<<endl;

	myReadFile.close();}
	if (p>=10)
		{myReadFile.open("f10.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[9]->num<<endl;
	myReadFile<<pptr[9]->name<<endl;
	for(int y=0;y<pptr[9]->num;y++)
		myReadFile<<pptr[9]->action[y]<<endl;

	myReadFile.close();}
	
	if (p>=11)
		{myReadFile.open("f11.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[10]->num<<endl;
	myReadFile<<pptr[10]->name<<endl;
	for(int y=0;y<pptr[10]->num;y++)
		myReadFile<<pptr[10]->action[y]<<endl;

	myReadFile.close();}
	if (p>=12)
		{myReadFile.open("f12.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[11]->num<<endl;
	myReadFile<<pptr[11]->name<<endl;
	for(int y=0;y<pptr[11]->num;y++)
		myReadFile<<pptr[11]->action[y]<<endl;

	myReadFile.close();}
	if (p>=13)
		{myReadFile.open("f13.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[12]->num<<endl;
	myReadFile<<pptr[12]->name<<endl;
	for(int y=0;y<pptr[12]->num;y++)
		myReadFile<<pptr[12]->action[y]<<endl;

	myReadFile.close();}
	if (p>=14)
		{myReadFile.open("f14.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[13]->num<<endl;
	myReadFile<<pptr[13]->name<<endl;
	for(int y=0;y<pptr[13]->num;y++)
		myReadFile<<pptr[13]->action[y]<<endl;

	myReadFile.close();}
	if (p>=15)
		{myReadFile.open("f15.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[14]->num<<endl;
	myReadFile<<pptr[14]->name<<endl;
	for(int y=0;y<pptr[14]->num;y++)
		myReadFile<<pptr[14]->action[y]<<endl;

	myReadFile.close();}
	if (p>=16)
		{myReadFile.open("f16.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[15]->num<<endl;
	myReadFile<<pptr[15]->name<<endl;
	for(int y=0;y<pptr[15]->num;y++)
		myReadFile<<pptr[15]->action[y]<<endl;

	myReadFile.close();}
	if (p>=17)
		{myReadFile.open("f17.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[16]->num<<endl;
	myReadFile<<pptr[16]->name<<endl;
	for(int y=0;y<pptr[16]->num;y++)
		myReadFile<<pptr[16]->action[y]<<endl;

	myReadFile.close();}
	if (p>=18)
		{myReadFile.open("f18.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[17]->num<<endl;
	myReadFile<<pptr[17]->name<<endl;
	for(int y=0;y<pptr[17]->num;y++)
		myReadFile<<pptr[17]->action[y]<<endl;

	myReadFile.close();}
	if (p>=19)
		{myReadFile.open("f19.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[18]->num<<endl;
	myReadFile<<pptr[18]->name<<endl;
	for(int y=0;y<pptr[18]->num;y++)
		myReadFile<<pptr[18]->action[y]<<endl;

	myReadFile.close();}
	if (p>=20)
		{myReadFile.open("f20.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<pptr[19]->num<<endl;
	myReadFile<<pptr[19]->name<<endl;
	for(int y=0;y<pptr[19]->num;y++)
		myReadFile<<pptr[19]->action[y]<<endl;

	myReadFile.close();
	//code showing message of saving


	//end of code
	}

	MessageBox::Show("All data are saved normally.");
		 }
private: System::Void button2_Click_1(System::Object^  sender, System::EventArgs^  e) {


		 }
private: System::Void button3_Click(System::Object^  sender, System::EventArgs^  e) {

		 }
private: System::Void label4_Click(System::Object^  sender, System::EventArgs^  e) {
		 }
		 
private: System::Void r1_CheckedChanged(System::Object^  sender, System::EventArgs^  e) {

		 }
private: System::Void r2_CheckedChanged(System::Object^  sender, System::EventArgs^  e) {
			
		 }
private: System::Void r3_CheckedChanged(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void r1_CheckedChanged_1(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void r1_KeyPress(System::Object^  sender, System::Windows::Forms::KeyPressEventArgs^  e) {
		 }
private: System::Void r1_Click(System::Object^  sender, System::EventArgs^  e) 
{	
		 }
private: System::Void r2_Click(System::Object^  sender, System::EventArgs^  e) {
    
		 }
private: System::Void r3_Click(System::Object^  sender, System::EventArgs^  e) {

		 }
private: System::Void tl_MouseEnter(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void tl_Click(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void button6_Click(System::Object^  sender, System::EventArgs^  e) {
			
		 }
private: System::Void text_TextChanged(System::Object^  sender, System::EventArgs^  e) {
			


		 }
private: System::Void list_SelectedIndexChanged(System::Object^  sender, System::EventArgs^  e) {
	 if(p==0)
			{MessageBox::Show("Sorry no profile to display");
			return;}
			 text->ForeColor=Color::Black;
text->BackColor=Color::Pink;

text->Text=gcnew String((">> "+pptr[list->SelectedIndex]->name).c_str());

		 }
private: System::Void list_SelectedIndexChanged_1(System::Object^  sender, System::EventArgs^  e) {

		

		 }
private: System::Void button7_Click(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void mylist_SelectedIndexChanged(System::Object^  sender, System::EventArgs^  e) {
			 			 if(p==0)
			{MessageBox::Show("Sorry no profile to display data from");
			return;}

			 if (pptr[list->SelectedIndex]->num==0)
			 {MessageBox::Show("No data in the profile to be displayed");
			 return;}

text->ForeColor=Color::Black;
text->BackColor=Color::Lime;

text->Text=gcnew String((">> "+pptr[list->SelectedIndex]->action[mylist->SelectedIndex]).c_str());
		 }
private: System::Void mylist_DoubleClick(System::Object^  sender, System::EventArgs^  e) {
			 if(p==0)
			{MessageBox::Show("Sorry no profile to delete data from");
			return;}

			 if (pptr[list->SelectedIndex]->num==0)
			 {MessageBox::Show("No data in the profile to be deleted");
			 return;}
			 if (MessageBox::Show("Are you sure that you would like to delete this mission ?","Confirmation box", MessageBoxButtons::YesNo, MessageBoxIcon::Question) == System::Windows::Forms::DialogResult::Yes)
{int j = list->SelectedIndex;
	int jo=mylist->SelectedIndex;		
			 for(jo;jo<pptr[list->SelectedIndex]->num;jo++)
				pptr[list->SelectedIndex]->action[jo]=pptr[list->SelectedIndex]->action[jo+1];
			pptr[list->SelectedIndex]->action [jo]='/0';
			pptr[list->SelectedIndex]->num--;
			mylist->Items->Clear();
 			for(int i=0;i<pptr[list->SelectedIndex]->num;i++)
			mylist->Items->Add(gcnew String((">> "+pptr[list->SelectedIndex]->action[i]).c_str()));
}		 }
private: System::Void mylist_Enter(System::Object^  sender, System::EventArgs^  e) {

			 		
		 }
private: System::Void rub_Click(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void list1_SelectedValueChanged(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void listBox1_SelectedIndexChanged(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void list2_SelectedValueChanged(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void list3_SelectedValueChanged(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void groupBox2_Enter(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void profileadd_CheckedChanged(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void misssionadd_CheckedChanged(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void profileadd_Click(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void misssionadd_Click(System::Object^  sender, System::EventArgs^  e) {

		 }

private: System::Void text1_TextChanged(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void text_TextChanged_1(System::Object^  sender, System::EventArgs^  e) {
addbt->Visible=true;
		 }
private: System::Void addbt_Click(System::Object^  sender, System::EventArgs^  e)
		 {if (selected)
		 {	pptr[p]->name=marshal_as<std::string>(text->Text);
			p++;
			list->Items->Clear();

			for(int k=0;k<p;k++)
		 list->Items->Add(gcnew String((">> "+pptr[k]->name).c_str()));

		}
		 else
		 { pptr[list->SelectedIndex]->action[pptr[list->SelectedIndex]->num]=marshal_as<std::string>(text->Text);
			pptr[list->SelectedIndex]->num++;
			mylist->Items->Clear();
		  	for(int i=0;i<pptr[list->SelectedIndex]->num;i++)
			mylist->Items->Add(gcnew String((">> "+pptr[list->SelectedIndex]->action[i]).c_str()));
		 }
		 		 addbt->Visible=false;
				 text->Clear();
		 }

private: System::Void addlist_SelectedValueChanged(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void list_SelectedValueChanged_1(System::Object^  sender, System::EventArgs^  e) {
		mylist->Items->Clear();
			for(int i=0;i<pptr[list->SelectedIndex]->num;i++)
			mylist->Items->Add(gcnew String((">> "+pptr[list->SelectedIndex]->action[i]).c_str()));



		 }
private: System::Void button6_Click_1(System::Object^  sender, System::EventArgs^  e) {
			 			 initial();
			 if (MessageBox::Show("Are you sure that you would like to delete all data?","Confirmation box", MessageBoxButtons::YesNo, MessageBoxIcon::Question) == System::Windows::Forms::DialogResult::Yes)
{			 {myReadFile.open("f1.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f2.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f3.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f4.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f5.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f6.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f7.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f8.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f9.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f10.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f11.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f12.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f13.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f14.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f15.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f16.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f17.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f18.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f19.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
	
		{myReadFile.open("f20.txt", ios::trunc | ios::out |ios::in | ios::binary);
		myReadFile<<0;
		myReadFile.close();}
		for(int i=0;i<p;i++)
	pptr[i]=ptr;
	p=0;
			myReadFile.open("numobj.txt", ios::trunc | ios::out |ios::in | ios::binary);
	myReadFile<<p;
	myReadFile.close();

	MessageBox::Show("All data deleted successfully.");}




		 }
private: System::Void list_SelectedIndexChanged_2(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void list_Click(System::Object^  sender, System::EventArgs^  e) {

		 }
private: System::Void mylist_Click(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void list_MouseEnter(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void list_MouseDown(System::Object^  sender, System::Windows::Forms::MouseEventArgs^  e) {
         

		 }
private: System::Void list_MouseHover(System::Object^  sender, System::EventArgs^  e) {
			 
		 }
private: System::Void list_DoubleClick(System::Object^  sender, System::EventArgs^  e) {     
			if (p==0)
			{
			MessageBox::Show("NO profile to be deleted");
return;			
			}
			 if (MessageBox::Show("Are you sure that you would like to delete this profile ?","Confirmation box", MessageBoxButtons::YesNo, MessageBoxIcon::Question) == System::Windows::Forms::DialogResult::Yes)    
			 {int j=list->SelectedIndex;
					for(j;j<p;j++)
					pptr[j]=pptr[j+1];
						p--;
						list->Items->Clear();
						mylist->Items->Clear();
	for(int k=0;k<p;k++)
		 list->Items->Add(gcnew String((">> "+pptr[k]->name).c_str()));
			  }

		 }
private: System::Void mylist_DragDrop(System::Object^  sender, System::Windows::Forms::DragEventArgs^  e) {
		 }
private: System::Void list_Enter(System::Object^  sender, System::EventArgs^  e) {

			 
	
		 }
private: System::Void list_KeyPress(System::Object^  sender, System::Windows::Forms::KeyPressEventArgs^  e) {
				 if (p==20)
		{MessageBox::Show("Sorry , no space to new profile.");
		return;}
text->Clear();
selected=true;
text->ForeColor=Color::Black;
text->BackColor=Color::White;

		 }
private: System::Void mylist_KeyPress(System::Object^  sender, System::Windows::Forms::KeyPressEventArgs^  e) {
			 	 if(p==0)
			{MessageBox::Show("Sorry no profile to add data in");
			return;}

			 if (pptr[list->SelectedIndex]->num==20)
			 {MessageBox::Show("Sorry no space to add new data in this profile");
			 return;}
			 text->Clear();
			 selected=false;
			text->ForeColor=Color::White;
			text->BackColor=Color::SteelBlue;
		 }
private: System::Void button1_Click_3(System::Object^  sender, System::EventArgs^  e) {


	myReadFile.open("output.txt", ios::trunc | ios::out );
	myReadFile<<pptr[list->SelectedIndex]->name<<"\n";
	for(int y=0;y<pptr[list->SelectedIndex]->num;y++)
	myReadFile<<y+1<<"- "<<pptr[list->SelectedIndex]->action[y]<<"\n";

	myReadFile.close();
	MessageBox::Show("I have send it :)");

		 }
private: System::Void button3_Click_1(System::Object^  sender, System::EventArgs^  e) {
			 
			pptr[list->SelectedIndex]->action[mylist->SelectedIndex]=marshal_as<std::string>(text->Text);
			mylist->Items->Clear();
			for(int i=0;i<pptr[list->SelectedIndex]->num;i++)
			mylist->Items->Add(gcnew String((">> "+pptr[list->SelectedIndex]->action[i]).c_str()));
		 }

};
}
