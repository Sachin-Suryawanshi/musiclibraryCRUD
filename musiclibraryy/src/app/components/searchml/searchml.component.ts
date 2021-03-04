import { Component, OnInit } from '@angular/core';
import { MusiclibraryService } from 'src/app/services/musiclibrary.service';

@Component({
  selector: 'app-searchml',
  templateUrl: './searchml.component.html',
  styleUrls: ['./searchml.component.css']
})
export class SearchmlComponent implements OnInit {
  songId="";
  musiclibrary:any;
  searchml=false;
  constructor(private musiclibraryService:MusiclibraryService) { }

  ngOnInit(): void {
  }

  getmusiclibrarybyId()
  {
    this.musiclibraryService.getmusiclibraryById(this.songId).subscribe((data)=>
    {
      console.log(data);
      this.musiclibrary=data;
      this.searchml=true;

    },err=>
    {
      console.log(err);
    })
  }

}
