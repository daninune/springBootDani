window.onload = () => {
   $(".delete-button").click((e) => {
      let projectName = $(e.target).attr('data-project-name');
      let projectId = $(e.target).attr('data-project-id');
      $("#project-name").html(projectName)
      $("#project-delete-button").attr("href", $("#project-delete-button").attr("data-target")+"="+projectId);
  });
  $(".edit-button").click((e) => {
      let targetVal = $(e.target).text();
      $(".from-title").text(targetVal);
      let projectName = $(e.target).attr('data-project-name');
      let projectId = $(e.target).attr('data-project-id');
      let projectComputable = JSON.parse($(e.target).attr('data-project-computable'));
      $("#from-Name-Project").val(projectName);
      $("#from-Id-Project").val(projectId);
      $("#computableProjectCheck").prop("checked", projectComputable);
  });

  $(".newProject").click((e) => {
        let targetVal = $(e.target).text();
        $(".from-title").text(targetVal);
        $("#computableProjectCheck").prop("checked", false);
        $("#from-Name-Project").val("");
    });
};