function solution(genres, plays) {
    let genresName = [];
    let songList = []
    for(let i = 0 ; i < genres.length; i++){
        if(genresName.indexOf(genres[i])===-1){
            genresName.push(genres[i]);
            songList.push({
                genre:genres[i],
                totalPlay:plays[i],
                playlst:0,
                song:[{
                    idx:i,
                    play:plays[i]
                }]
            })
        }else{
            let idx = genresName.indexOf(genres[i]);
            songList[idx].totalPlay += plays[i];
            songList[idx].song.push({
                idx:i,
                play:plays[i]
            })
        }
    }
    songList.sort((a,b)=>b.totalPlay-a.totalPlay);
    var answer = [];
    for(let i = 0 ; i < songList.length ; i++){
        songList[i].song.sort((a,b)=>b.play-a.play);
        for (let j = 0 ; j < songList[i].song.length; j++){
            if(j===2){break;}
            answer.push(songList[i].song[j].idx);
        }
    }
    return answer;
}