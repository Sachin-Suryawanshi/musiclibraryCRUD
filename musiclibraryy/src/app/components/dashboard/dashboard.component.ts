import { Component, OnInit } from '@angular/core';
import { MusiclibraryService } from 'src/app/services/musiclibrary.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
showdetails=false;
 musiclibrarytoupdate=
 {
   songId:"",
   songName:"",
   artistName:"",
   yearOfRealease:""
 }
  musiclibrary:any;
  constructor(private musiclibraryservicce:MusiclibraryService) { }

  ngOnInit(): void {
  }

  getallmusiclibrary()
  {
    this.musiclibraryservicce.getallmusicLibrarries().subscribe((data)=>
    {
      console.log(data);
      this.musiclibrary=data;
      this.showdetails=true;
    },err=>
    {
      console.log(err);
    })
  }

  searchmusiclibrary(songId:any)
  {
    this.musiclibraryservicce.getmusiclibraryById(songId).subscribe((data)=>
    {
      console.log(data);
    },err=>
    {
      console.log(err);
    })
  }

  updatemusiclibrary(musicupdate:any)
  {
    this.musiclibraryservicce.updatemusiclibrary(musicupdate.value).subscribe((data)=>
    {
      console.log(data);
    },err=>
    {
      console.log(err);
    })
  }
  deletemusiclibrary(musiclib:any)
  {
    this.musiclibraryservicce.deletemusiclibrary(musiclib.songId).subscribe((data)=>
    {
      console.log(data);
      
    },
    err=>
    {
      this.getallmusiclibrary();
      console.log(err);
    })
  }
  updatemusiclib(musiclib:any)
  {
    this.musiclibrarytoupdate=musiclib;
  }

}
