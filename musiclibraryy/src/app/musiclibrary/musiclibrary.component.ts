import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MusiclibraryService } from '../services/musiclibrary.service';

@Component({
  selector: 'app-musiclibrary',
  templateUrl: './musiclibrary.component.html',
  styleUrls: ['./musiclibrary.component.css']
})
export class MusiclibraryComponent implements OnInit {

  constructor(private musiclibraryService:MusiclibraryService,private router:Router) { }

  ngOnInit(): void {
  }

  insertmusiclibrary(musiclibrary:any)
  {
    this.musiclibraryService.insertmusiclibrary(musiclibrary.value).subscribe((data)=>
    {
      
      console.log(data);
    },err=>
    {
     
      console.log(err);
    })
  }

}
